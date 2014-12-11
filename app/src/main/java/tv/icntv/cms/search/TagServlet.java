package tv.icntv.cms.search;/*
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
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregations;
import tv.icntv.cms.response.searchvo.ProgramSeries;
import tv.icntv.cms.response.searchvo.Tag;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 16:43
 */
public class TagServlet extends AbstractSearchHttpServlet {
    private String year;
    @Override
    protected void fillParameter(HttpServletRequest request) {
        year = request.getParameter("year");
    }


    @Override
    protected FilterBuilder builderQuery() {
        if(!Strings.isNullOrEmpty(year)){
           return FilterBuilders.boolFilter().must(FilterBuilders.termFilter("year",year));
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public List getResult(SearchHits hits) throws Exception {
        List result = Lists.newArrayList();
        for (SearchHit hit : hits.getHits()) {
            try {
                ProgramSeries series = JSON.parseObject(hit.sourceAsString(), ProgramSeries.class);
                result.add(series);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        return result;
    }

}
