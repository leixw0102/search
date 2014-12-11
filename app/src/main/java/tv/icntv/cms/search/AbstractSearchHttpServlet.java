package tv.icntv.cms.search;/*
 * Copyright 2014 Future TV, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */


import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolFilterBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import tv.icntv.cms.AbstractHttpServlet;
import tv.icntv.cms.response.Msg;
import tv.icntv.cms.response.Response;
import tv.icntv.cms.response.searchvo.Tag;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/08/25
 * Time: 09:19
 */
public abstract class AbstractSearchHttpServlet extends AbstractHttpServlet {
    protected String platformId = "b";
    protected int region = 1;
    protected int pageNo = 0;
    protected int limit = 1;
    private String primary_tag = "";
    private String secondary_tag = "";

    @Override
    protected void fillParameter(HttpServletRequest request) {

        platformId = Preconditions.checkNotNull(request.getParameter("platformId"), "platformId null");
        region = Ints.tryParse(Preconditions.checkNotNull(request.getParameter("region"), "region null"));
        pageNo = Ints.tryParse(Preconditions.checkNotNull(request.getParameter("pageNo"), "pageNo position null "));
        String limitTemp = Preconditions.checkNotNull(request.getParameter("limit"), "result limit null ");
        if (!Strings.isNullOrEmpty(limitTemp)) {
            limit = Ints.tryParse(limitTemp);
        }
        primary_tag = Preconditions.checkNotNull(request.getParameter("primaryTag"), "primary tag null");
        secondary_tag = request.getParameter("secondaryTag");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        try {
            fillParameter(req);
        } catch (Exception e) {
            output(JSON.toJSONString(Response.ILLEGAL_PARAMETER_MSG), resp);
            return;
        }
        SearchRequestBuilder builder = customSearchRequest();

        AggregationBuilder aggregationBuilder = builderAggregation();
        if (null != aggregationBuilder) {
            builder.addAggregation(aggregationBuilder);
        }

        Response result = null;
        try {
            SearchResponse response = builder.setFrom(pageNo * limit).setSize(limit).execute().actionGet();
            //set commons
            SearchHits hits = response.getHits();
            long total = hits.getTotalHits();
            if (total <= 0) {
                output(JSON.toJSONString(new Response("result null", 2)), resp);
                return;
            }
            Msg msg = setResultCommon(total);
            List body = getResult(hits);
            msg.setList(body);
            List<Tag> tags=getAggreation(response.getAggregations());
            msg.setPrimary_tag(tags);
            result = new Response(msg, "success", 0);
        } catch (Exception e) {
            output(e.getMessage(), resp);
            return;
        }

        output(JSON.toJSONString(result, true), resp);
    }

    protected List<Tag> getAggreation(Aggregations aggregations){
        Terms first = aggregations.get(agg_primary_name);
        List<Tag> tags = Lists.newArrayList();
        for (Terms.Bucket buket : first.getBuckets()) {
            Tag primary = new Tag();
            primary.setCount(buket.getDocCount());
            primary.setName(buket.getKey());
            Terms secondary=buket.getAggregations().get(agg_secondary_name);
            List<Tag> secondaries=Lists.newArrayList();
            for(Terms.Bucket b :secondary.getBuckets()){
                Tag secondary_tag = new Tag();
                secondary_tag.setName(b.getKey());
                secondary_tag.setCount(b.getDocCount());
                secondaries.add(secondary_tag);
            }
            primary.setSecondary_tag(secondaries);
            tags.add(primary);
        }
        return tags;  //To change body of implemented methods use File | Settings | File Templates.
    };
    private String agg_primary_name = "primary_count";
    private String agg_secondary_name = "secondary_count";

    /**
     * 构建查询条件
     */
    protected abstract FilterBuilder builderQuery();

    protected  AggregationBuilder builderAggregation(){
        return AggregationBuilders.terms(agg_primary_name).field("tag_arr.primary_tag.tag_name").subAggregation(AggregationBuilders.terms(agg_secondary_name).field("tag_arr.primary_tag.secondary_tag.tag_name"));
    };

    protected Msg setResultCommon(long total) {
        return new Msg(limit, pageNo, total);
    }

    public abstract List getResult(SearchHits response) throws Exception;

    /**
     * 创建 search builder
     *
     * @return
     */
    protected SearchRequestBuilder customSearchRequest() {
        BoolFilterBuilder bFilter = FilterBuilders.boolFilter().
                must(FilterBuilders.termFilter("region_code", region)).
                must(FilterBuilders.termFilter("platform_code", platformId))
                .must(FilterBuilders.boolFilter().must(FilterBuilders.termFilter("tag_arr.primary_tag.tag_name", primary_tag)));

        if (!Strings.isNullOrEmpty(secondary_tag)) {
            bFilter.must(FilterBuilders.boolFilter().must(FilterBuilders.termFilter("tag_arr.primary_tag.secondary_tag.tag_name", secondary_tag)));
        }
        FilterBuilder filterBuilder = builderQuery();
        if (null != filterBuilder) {
            bFilter.must(builderQuery());
        }
        return client.prepareSearch(alias).setTypes(type).setPostFilter(bFilter);
    }

//    protected void setGroupAggretationResult(Terms terms){
//        System.out.println(terms.getBuckets().size());
//        for(Terms.Bucket b: terms.getBuckets()){
//            System.out.println(b.getKey());
//            primary_tags.add(new Tag((int)b.getDocCount(),b.getKey()));
//        }
//    }

}
