package tv.icntv.search.utils;/*
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
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import tv.icntv.search.domain.ProgramSeries;
import tv.icntv.search.domain.TagSource;

import java.io.IOException;
import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/12/03
 * Time: 14:34
 */
public class ESJsonUtils {
    private static class Constant{
        public static String PROGRAM_SERIES_ID="program_series_id";
        public static String PROGRAM_SERIES_NAME="program_series_name";
        public static String PROGRAM_SERIES_EN_NAME="program_series_en_name";
        public static String PROGRAM_SERIES_HEADER="program_series_header";
        public static String PROGRAM_SERIES_DESC="program_series_desc";
        public static String PLATFORM_CODE="platform_code";
        public static String REGION_CODE="region_code";
        public static String POSTER="poster";
        public static String SMALL_POSTER_ADDR="small_poster_addr";
        public static String BIG_POSTER_ADDR="big_poster_addr";
        public static String IS_3D="is3d";
        public static String TIME_LENGTH="time_length";
        public static String IS_CUSTOMER="is_customer";
        public static String STAR_RATION="star_rating";
        public static String ZONE="zone";
        public static String CP_PRODUCER="cp_producer";
        public static String TAG_NAME="tag_name";
        public static String ARTIST_ID="artist_id";
        public static String PAR_NAME="par_name";
        public static String PAR_PINYIN="par_pinyin";
        public static String TASK="task";
        public static String sendJmsDate="activeTime";
        public static String YEAR="year";
    }

    public static String getMapping(String type) throws IOException {
        XContentBuilder xBuilder = XContentFactory.jsonBuilder().prettyPrint()
                .startObject()
//                    .startObject("mapping")
                .startObject(type)
                .startObject("properties")
                .startObject(Constant.PROGRAM_SERIES_ID).field("type", "long").field("store", "true").endObject()
                .startObject(Constant.PROGRAM_SERIES_NAME).field("type", "string").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
                .startObject(Constant.PROGRAM_SERIES_EN_NAME).field("type", "string").endObject()
                .startObject(Constant.PROGRAM_SERIES_HEADER).field("type", "string").endObject()
                .startObject(Constant.PLATFORM_CODE).field("type", "string").endObject()
                .startObject(Constant.REGION_CODE).field("type", "string").endObject() //版权区域
                .startObject(Constant.sendJmsDate).field("type","date").field("format","yyyy-MM-dd HH:mm:ss").field("index", "not_analyzed").endObject()
                .startObject(Constant.YEAR).field("type","string").endObject()
                .startObject(Constant.POSTER).field("type", "string").endObject()
                .startObject(Constant.SMALL_POSTER_ADDR).field("type", "string").endObject()
                .startObject(Constant.BIG_POSTER_ADDR).field("type", "string").endObject()
                .startObject(Constant.IS_3D).field("type", "integer").endObject()
                .startObject(Constant.TIME_LENGTH).field("type", "integer").endObject()
                .startObject(Constant.IS_CUSTOMER).field("type", "integer").endObject()
                .startObject(Constant.STAR_RATION).field("type", "float").endObject() //评分
                .startObject(Constant.ZONE).field("type", "string").endObject()   //地区
//                            .startObject(Constant.CP_PRODUCER).field("type", "string").endObject()
                .startObject(Constant.PROGRAM_SERIES_DESC).field("type", "string").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
                        //                            .startObject("tag_arr")
                .startObject("tag_arr")
                .startObject("properties")
                .startObject("primary_tag")
                .startObject("properties")
                .startObject(Constant.TAG_NAME).field("type", "string").field("index", "not_analyzed").endObject()
                .startObject("secondary_tag")
                .startObject("properties")
                .startObject(Constant.TAG_NAME).field("type", "string").field("index", "not_analyzed").endObject()
                .startObject("primary_secondary_tag").field("type", "string").field("index", "not_analyzed").endObject()
                .endObject()
                .endObject()
                .endObject()
                .endObject()
                .startObject("tertiary_tag")
                .startObject("properties")
                .startObject(Constant.TAG_NAME).field("type", "string").field("index", "not_analyzed").endObject()
                .endObject()
                .endObject()
                .endObject()
                .endObject()
                        //                            //                .endObject()
                .startObject("artist")
                .startObject("properties")
                .startObject(Constant.ARTIST_ID).field("type", "long").endObject()
                .startObject(Constant.PAR_NAME).field("type", "string").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
                .startObject(Constant.PAR_PINYIN).field("type", "string").endObject()
                .startObject(Constant.TASK).field("type", "integer").endObject()
                .endObject()
                .endObject()
                .endObject()
                .endObject()
//                    .endObject()
                .endObject();
        return xBuilder.string();
    }

    public static XContentBuilder getIndexJson(ProgramSeries programSeries) throws IOException {
        XContentBuilder jsonBuild = XContentFactory.jsonBuilder().prettyPrint();
        jsonBuild.startObject();
        jsonBuild.field(Constant.PROGRAM_SERIES_ID,programSeries.getId()); //节目集ID
        jsonBuild.field(Constant.PROGRAM_SERIES_NAME,programSeries.getProgramSeriesName());//节目名称
        jsonBuild.field(Constant.PROGRAM_SERIES_EN_NAME,programSeries.getProgramSeriesEnName());     //节目EN名称
        jsonBuild.field(Constant.PROGRAM_SERIES_HEADER, programSeries.getProgramHeader()); //首字母
        jsonBuild.field(Constant.PLATFORM_CODE, programSeries.getPlatformName());
        jsonBuild.field(Constant.REGION_CODE, programSeries.getCopyRightZone());
        jsonBuild.field(Constant.POSTER, programSeries.getPosterAddr());
        jsonBuild.field(Constant.SMALL_POSTER_ADDR, programSeries.getSmallPosterAddr());
        jsonBuild.field(Constant.BIG_POSTER_ADDR, programSeries.getBigPosterAddr());
        jsonBuild.field(Constant.IS_3D, programSeries.getIs3d());
        jsonBuild.field(Constant.TIME_LENGTH, programSeries.getProgramLength());
        jsonBuild.field(Constant.IS_CUSTOMER, programSeries.getCustomer());
        jsonBuild .field(Constant.STAR_RATION, programSeries.getGrade());
        jsonBuild.field(Constant.ZONE, programSeries.getZone());
//                .field(Constant.CP_PRODUCER,programSeries.get)
        jsonBuild.field(Constant.PROGRAM_SERIES_DESC, programSeries.getProgramSeriesDesc());
        jsonBuild.startObject("tag_arr");
        setTagSource(programSeries.getTags(),jsonBuild);
        jsonBuild.endObject()
                .endObject();
        return jsonBuild;
    }

    private static String secondary_tag="secondary_tag";
    private static void setTagSource(TagSource[] tagSource ,XContentBuilder jsonBuilder ) throws IOException {
        jsonBuilder.startArray("primary_tag");
        for(TagSource source : tagSource){

            if(source.getTagLevel()==3){
//                       jsonBuilder.startArray("tertiary_tag").startObject();

            } else {

                jsonBuilder.startObject();
                jsonBuilder.field(Constant.TAG_NAME,source.getTagName());
                jsonBuilder.startArray(secondary_tag);

                for(TagSource child:source.getChildTagSource()){
                    jsonBuilder.startObject().field(Constant.TAG_NAME, child.getTagName());
                    jsonBuilder.field("primary_secondary_tag",source.getTagName()+"-"+child.getTagName()).endObject();
                }
                jsonBuilder.endArray().endObject();
            }
        }
        jsonBuilder.endArray() ;
    }

    public static void main(String[]args) throws IOException {
        ProgramSeries p = new ProgramSeries();
        p.setBigPosterAddr("abc");
        p.setCopyRightZone(new String[]{"a", "b"});
        p.setCustomer(1);
        p.setGrade(9.8f);
        p.setId(1);
        p.setIs3d(0);
        p.setPlatformName(new String[]{"sanxing", "android"});
        p.setPosterAddr("http://baidu.com");
        p.setProgramHeader("jaqjxdd");
        p.setProgramLength(23);
        p.setProgramSeriesName("将爱情进行到底");
        p.setProgramPinyin("jiangaiqingjinxingdaodi");
        p.setProgramSeriesEnName("abcdefg");
        p.setProgramTotalCount(4);
        TagSource tagSource = new TagSource();
        tagSource.setId(1);
        tagSource.setTagLevel(1);
        tagSource.setTagName("test");
        TagSource child1 = new TagSource();
        child1.setId(2);
        child1.setTagLevel(2);
        child1.setTagName("test1");
        TagSource child2 = new TagSource();
        child2.setId(3);
        child2.setTagLevel(2);
        child2.setTagName("test2");
        tagSource.setChildTagSource(new TagSource[]{child1, child2});
        p.setTags(new TagSource[]{tagSource});
        System.out.println(JSON.toJSONString(p,true));
        System.out.println(getIndexJson(p).string());
    }
}