/*
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

import org.elasticsearch.client.FilterClient;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tv.icntv.search.elastic.Search;
import tv.icntv.search.index.Create;
import tv.icntv.search.utils.ESJsonUtils;

import java.io.IOException;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/18
 * Time: 14:37
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Search search = Search.getInstance();
        TransportClient client = search.getESClient();
        IndicesAdminClient action =  client.admin().indices();
        System.out.println("check index isExist");
        if (!action.exists(Requests.indicesExistsRequest(search.getIndex())).actionGet().isExists()) {
            action.prepareCreate(search.getIndex()).execute().actionGet();
            action.putMapping(Requests.putMappingRequest(search.getIndex()).type(search.getType()).source(ESJsonUtils.getMapping(search.getType()))).actionGet();
            search.setAlias2Index(search.getAlias(), search.getIndex());
        }
        search.close(client);
        new ClassPathXmlApplicationContext("applicationContext-jms.xml");
    }
}
