package tv.icntv.search.elastic;/*
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

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import tv.icntv.search.domain.ProgramSeries;
import tv.icntv.search.utils.ESJsonUtils;

import java.io.IOException;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/12/11
 * Time: 14:09
 */
public class Index {

    Search search  = Search.getInstance();;

    TransportClient client = search.getESClient();;
    public  boolean createIndex(ProgramSeries programSeries){
        return createIndex(new ProgramSeries[]{programSeries});
    }
    public  boolean createIndex(ProgramSeries ...programSerieses){
        try{
            BulkRequestBuilder bulk= client.prepareBulk();
            for(ProgramSeries item:programSerieses){
                bulk.add(client.prepareIndex(search.getAlias(), search.getType(), item.getId() + "").setSource(ESJsonUtils.getIndexJson(item)));
            }
            BulkResponse responses=bulk.execute().actionGet();
            return !responses.hasFailures();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }
    }

    public  boolean deleteIndex(ProgramSeries programSeries){
        DeleteResponse deleteResponse = client.prepareDelete(search.getAlias(),search.getType(),programSeries.getId()+"").setOperationThreaded(false).execute().actionGet();
        boolean result =  deleteResponse.isFound();
        client.close();
        return result;
    }

    public  boolean update(ProgramSeries programSeries){
        try {
            UpdateResponse updateResponse = client.prepareUpdate(search.getAlias(),search.getType(),programSeries.getId()+"").setSource(ESJsonUtils.getIndexJson(programSeries)).execute().actionGet();
            return updateResponse.isCreated();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return true;
    }
}
