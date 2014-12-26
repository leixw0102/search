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
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.elasticsearch.index.query.BoolFilterBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import tv.icntv.cms.response.searchvo.ProgramSeries;
import tv.icntv.cms.response.searchvo.Tag;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 14:52
 */
public class ProgramSeriesServlet extends AbstractSearchHttpServlet {
    private String q;
    private int type = 1;

    @Override
    protected void fillParameter(HttpServletRequest request) {
        super.fillParameter(request);
        q = Preconditions.checkNotNull(request.getParameter("q"), "query string null");
        type = Ints.tryParse(request.getParameter("type"));
    }




    @Override
    protected BoolFilterBuilder builderQuery() {
        logger.info("q={}",q);
        if (1==type) {
            return FilterBuilders.boolFilter().must(FilterBuilders.prefixFilter("program_series_header", q));
        }
        if (2==type) {
            return FilterBuilders.boolFilter().must(FilterBuilders.prefixFilter("artist.par_pinyin", q));
        }
        return null;
    }


    @Override
    public List getResult(SearchHits hits) throws Exception {
        List result = Lists.newArrayList();
        for (SearchHit hit : hits.getHits()) {
            try {
//                System.out.println(hit.sourceAsString());
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
