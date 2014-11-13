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
package tv.icntv.search.elastic;

import org.elasticsearch.client.transport.TransportClient;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/11/13
 * Time: 16:12
 */
public interface ISearch {
    public TransportClient getESClient();
    public String getAlias();
    public String getIndex();
    public String getType();
    public void setAlias2Index(String alias,String index) throws Exception;
}
