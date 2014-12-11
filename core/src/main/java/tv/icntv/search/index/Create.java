package tv.icntv.search.index;/*
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

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 16:58
 */
public class Create {
    public static String getCreateMapping() throws IOException {
        XContentBuilder xBuilder = XContentFactory.jsonBuilder()
                .startObject()
                    .startObject("items")
                        .startObject("properties")
                            .startObject("program_series_id").field("type", "long").field("store", "true").endObject()
                            .startObject("program_series_name").field("type", "string").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
                            .startObject("program_series_en_name").field("type","string").endObject()
                            .startObject("program_series_header").field("type","string").endObject()
                            .startArray("platform_code").field("type", "string").endArray()
                            .startArray("region_code").field("type", "string").endArray() //版权区域

                            .startObject("poster").field("type", "string").endObject()
                            .startObject("small_poster_addr").field("type", "string").endObject()
                            .startObject("big_poster_addr").field("type", "string").endObject()
                            .startObject("is3d").field("type", "integer").endObject()
                            .startObject("time_length").field("type", "integer").endObject()
                            .startObject("is_customer").field("type", "integer").endObject()
                            .startObject("star_ration").field("type", "integer").endObject() //评分
                            .startObject("zone").field("type", "string").endObject()   //地区
                            .startObject("cp_producer").field("type", "string").endObject()
                            .startObject("program_series_desc").field("type", "string").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
            //                            .startObject("tag_arr")
                            .startObject("tag_arr")
                                .startObject("properties")
                                    .startObject("primary_tag")
                                        .startObject("properties")
                                            .startObject("tag_name").field("type", "string").field("index", "not_analyzed").endObject()
                                            .startObject("secondary_tag")
                                                .startObject("properties")
                                                    .startObject("tag_name").field("type", "string").field("index", "not_analyzed").endObject()
                                                 .endObject()
                                            .endObject()
                                        .endObject()
                                    .endObject()
                                    .startObject("tertiary_tag")
                                        .startObject("properties")
                                            .startObject("tag_name").field("type", "string").field("index", "not_analyzed").endObject()
                                        .endObject()
                                    .endObject()
                                .endObject()
                            .endObject()
            //                        //                .endObject()
                            .startObject("artist")
                                .startObject("properties")
                                    .startObject("artist_id").field("type", "long").endObject()
                                    .startObject("par_name").field("type", "string").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
                                    .startObject("par_pinyin").field("type", "string").endObject()
                                    .startObject("task").field("type", "integer").endObject()
                                .endObject()
                            .endObject()
                        .endObject()
                    .endObject()
                .endObject();
        return xBuilder.string();
    }
}
