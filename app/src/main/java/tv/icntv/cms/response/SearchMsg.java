package tv.icntv.cms.response;/*
 * Copyright 2014 Future TV, Inc.
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.icntv.tv/licenses/LICENSE-1.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolFilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import tv.icntv.cms.response.searchvo.ProgramSeries;
import tv.icntv.cms.response.searchvo.Tag;
import tv.icntv.search.elastic.Search;

import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 15:02
 */
public  class SearchMsg {

     public static void main(String[]args){
         Search search =  Search.getInstance();
         TransportClient client = search.getESClient();
         BoolFilterBuilder bFilter= FilterBuilders.boolFilter().
                 must(FilterBuilders.termFilter("region_code","a")).
                 must(FilterBuilders.termFilter("platform_code", "sanxing"))
//                .must(FilterBuilders.boolFilter().must(FilterBuilders.termFilter("tag_arr.primary_tag.tag_name", "言情")))
                 .must(FilterBuilders.boolFilter().must(FilterBuilders.prefixFilter("program_series_header", "xp")));
         SearchResponse response =   client.prepareSearch("cms_v1").setTypes("item").setPostFilter(bFilter)
                 .addAggregation(AggregationBuilders.terms("first").field("tag_arr.primary_tag.tag_name").subAggregation(AggregationBuilders.terms("secondary").field("tag_arr.primary_tag.secondary_tag.tag_name"))).setFrom(0).setSize(1).execute().actionGet();
//        System.out.println(response.toString());
         SearchHits hits=response.getHits();
         System.out.println(hits.getTotalHits());
//
         Response response1 = new Response("success",0);
         Msg msg = new Msg(2,2,3);
         for(SearchHit hit:hits){
//
             System.out.println(hit.sourceAsString());
             ProgramSeries items= JSON.parseObject(hit.source(), ProgramSeries.class);
//             System.out.println(items.toString());
////            System.out.println(items.getProgram_series_name() +" \t" + items.getArtist().get(0).getArtist_id());
//            //            Map<String,Object> maps=hit.sourceAsMap();
////
////            Set<String> keys= maps.keySet();
////            for(String str:keys){
////                System.out.println(str+"\t"+maps.get(str));
////            }
             msg.setList(Lists.newArrayList(items));
             Terms first = response.getAggregations().get("first");
             List<Tag> tags = Lists.newArrayList();
             for (Terms.Bucket buket : first.getBuckets()) {
                 Tag primary = new Tag();
                 primary.setCount(buket.getDocCount());
                 primary.setName(buket.getKey());
                 Terms secondary=buket.getAggregations().get("secondary");
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
             msg.setPrimary_tag(tags);
         }
         response1.setData(msg);
         System.out.println(JSON.toJSONString(response1));
     }

}
