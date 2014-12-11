package tv.icntv.test;/*
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

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import tv.icntv.search.elastic.Search;
import tv.icntv.search.utils.ESJsonUtils;

import java.io.IOException;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/12/03
 * Time: 09:59
 */
public class Create {
    public static void main(String[]args) throws IOException {
//        ProgramSeries p = new ProgramSeries();
//        p.setBigPosterAddr("abc");
//        p.setCopyRightZone(new String[]{"a", "b"});
//        p.setCustomer(1);
//        p.setGrade(9.8f);
//        p.setId(3);
//        p.setIs3d(0);
//        p.setPlatformName(new String[]{"sanxing", "android"});
//        p.setPosterAddr("http://baidu.com");
//        p.setProgramHeader("xplg");
//        p.setProgramLength(23);
//        p.setProgramSeriesName("三十六计");
//        p.setProgramPinyin("xiaopingguo");
//        p.setProgramSeriesEnName("abcdefg");
//        p.setProgramTotalCount(4);
//        TagSource tagSource = new TagSource();
////        tagSource.setId(2);
////        tagSource.setTagLevel(1);
//        tagSource.setTagName("测试");
//        TagSource child1 = new TagSource();
////        child1.setId(2);
////        child1.setTagLevel(2);
//        child1.setTagName("国内");
//        TagSource child2 = new TagSource();
////        child2.setId(3);
////        child2.setTagLevel(2);
//        child2.setTagName("爱情");
//        tagSource.setChildTagSource(new TagSource[]{child1,child2});
//        p.setTags(new TagSource[]{tagSource});
//        System.out.println(ESJsonUtils.getIndexJson(p));
        Search search = new Search();
        TransportClient client = search.getESClient();
//        client.admin().indices().delete(Requests.deleteIndexRequest("cms_v1")).actionGet();
//        client.prepareDelete().(Requests.deleteRequest("cms_v1")).actionGet();
//        Requests.indexRequest("abc").type("d").source(Create.getCreateMapping());
        client.admin().indices().prepareCreate(search.getIndex()).execute().actionGet();
//        System.out.println(ESJsonUtils.getMapping());
        PutMappingRequest put = Requests.putMappingRequest(search.getIndex()).type(search.getType()).source(ESJsonUtils.getMapping(search.getType()));
        client.admin().indices().putMapping(put).actionGet();
        System.out.println(search.setAlias2Index(search.getAlias(),search.getIndex()));
//        IndexResponse response =  client.prepareIndex("cms_v1", "item",p.getId()+"").setSource(ESJsonUtils.getIndexJson(p)).execute().actionGet();
//        System.out.println(response.isCreated());
//        client.delete(Requests.deleteRequest("cms_v1").type("item").id("4"));

//        BoolFilterBuilder bFilter= FilterBuilders.boolFilter().
//                must(FilterBuilders.termFilter("region_code","a")).
//                must(FilterBuilders.termFilter("platform_code", "sanxing"))
////                .must(FilterBuilders.boolFilter().must(FilterBuilders.termFilter("tag_arr.primary_tag.tag_name", "言情")))
//                .must(FilterBuilders.boolFilter().must(FilterBuilders.prefixFilter("program_series_header", "xp")));
//        SearchResponse response =   client.prepareSearch("cms_v1").setTypes("item").setPostFilter(bFilter)
//                .addAggregation(AggregationBuilders.terms("first").field("tag_arr.primary_tag.tag_name").subAggregation(AggregationBuilders.terms("secondary").field("tag_arr.primary_tag.secondary_tag.tag_name"))).setFrom(0).setSize(1).execute().actionGet();
////        System.out.println(response.toString());
//        SearchHits hits=response.getHits();
//        System.out.println(hits.getTotalHits());
////
//        for(SearchHit hit:hits){
////
//            System.out.println(hit.sourceAsString());
//            ProgramSeries items= JSON.parseObject(hit.source(), ProgramSeries.class);
////            System.out.println(items.getProgram_series_name() +" \t" + items.getArtist().get(0).getArtist_id());
//            //            Map<String,Object> maps=hit.sourceAsMap();
////
////            Set<String> keys= maps.keySet();
////            for(String str:keys){
////                System.out.println(str+"\t"+maps.get(str));
////            }
//        }
//
//        Terms a=response.getAggregations().get("first");
//        for(Terms.Bucket b : a.getBuckets()){
//            System.out.println(b.getKey()+"\t"+b.getDocCount());
//            Terms c=b.getAggregations().get("secondary");
//            for(Terms.Bucket x : c.getBuckets()){
//                System.out.println("sssssssssss "+x.getKey()+"\t"+x.getDocCount());
//            }
//        }
//        if(!Strings.isNullOrEmpty(secondary_tag)){
//            bFilter.must(FilterBuilders.boolFilter().must(FilterBuilders.termFilter("tag_arr.primary_tag.secondary_tag.tag_name", secondary_tag)));
//        }
//        FilterBuilder filterBuilder = builderQuery();
//        if(null != filterBuilder){
//            bFilter.must(builderQuery());
//        }


        client.close();
    }
}
