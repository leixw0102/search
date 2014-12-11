package tv.icntv.cms;
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

import com.google.common.base.Charsets;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tv.icntv.search.elastic.ISearch;
import tv.icntv.search.elastic.Search;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/08/19
 * Time: 11:46
 */
public abstract class AbstractHttpServlet extends HttpServlet {
    /**
     * fill parameter
     * @param request
     */
    protected  abstract  void fillParameter(HttpServletRequest request) ;

    protected String alias;
    protected String type="item";
    protected TransportClient client=null;

    protected String JSON_CONTENT_TYPE="application/json; charset=UTF-8";
    private String RESPONSE_CONTENT_TYPE="response.content.type";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    ISearch search = null;
    /**
     * loader config & elastic search init.
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 获取配置文件参数
        search = new Search();
        alias =search.getAlias();
        type = search.getType();
        //获取xml中response返回的header信息   json
        JSON_CONTENT_TYPE=config.getServletContext().getInitParameter(RESPONSE_CONTENT_TYPE);
        client= search.getESClient();
    }

    /**
     * response json.
     * @param json
     * @param response
     * @throws IOException
     */
    protected void output(String json,HttpServletResponse response) throws IOException {
        response.setContentType(JSON_CONTENT_TYPE);
        response.getOutputStream().write(json.getBytes(Charsets.UTF_8));
        response.getOutputStream().close();
    }

    /**
     * destroy tcp connection of elastic search;
     */
    @Override
    public void destroy() {
        logger.info("destory....");
        if(null != client){
            client.close();
        }
        super.destroy();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
