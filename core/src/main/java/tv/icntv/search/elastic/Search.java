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

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import tv.icntv.search.utils.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/11/13
 * Time: 16:19
 */
public class Search implements ISearch, Config {
    Properties properties = null;

    public Search() {
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("elasticsearch-conf.properties");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public TransportClient getESClient() {
        List<InetSocketTransportAddress> list = getInetSocket();
        if(null == list || list.isEmpty()){
            return null;
        }
        Settings settings = ImmutableSettings.settingsBuilder().put(CLUSTER_NAME,properties.getProperty(CLUSTER_NAME)).put(CLIENT_TRANSPORT_SNIFF,properties.getProperty(CLIENT_TRANSPORT_SNIFF)).build();
        return new TransportClient(settings).addTransportAddresses(list.toArray(new InetSocketTransportAddress[list.size()]));
    }

    private List<InetSocketTransportAddress> getInetSocket() {
        List<InetSocketTransportAddress> list = Lists.newArrayList();
        String ips = properties.getProperty(CLUSTER_IPS_PORTS);
        if(Strings.isNullOrEmpty(ips)){
            return null;
        }
        for(String line : Splitter.on(",").split(ips)){
            String[]temps = line.split(":");
            list.add(new InetSocketTransportAddress(temps[0],Integer.parseInt(temps[1])));
        }
        return list;
    }

    @Override
    public String getAlias() {
        return properties.getProperty(CMS_SEARCH_ALIAS);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getIndex() {
        return properties.getProperty(CLUSTER_INDEX);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getType() {
        return properties.getProperty(CLUSTER_TYPE);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAlias2Index(String alias, String index) {
        IndicesAliasesRequest request = Requests.indexAliasesRequest();
        request.addAlias(getAlias(),getIndex());
        IndicesAliasesResponse response = getESClient().admin().indices().aliases(request).actionGet();
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
