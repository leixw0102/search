package tv.icntv.test.search.utils;/*
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

import com.google.common.base.Preconditions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tv.icntv.search.utils.PropertiesLoaderUtils;
import tv.icntv.test.AbstractTest;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 13:50
 */

public class PropertiesLoaderUtilsTest extends AbstractTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Properties properties=null;
    @Before
    @Override
    public void init() {

        logger.info("load properties ...");

    }
    @Test
    public void testJunit(){
        logger.info("....");
    }

    @Test
    public void testLoaderConfig(){

        try {
            properties = PropertiesLoaderUtils.loadAllProperties("elasticsearch-conf.properties");
        } catch (IOException e) {
            logger.error("error file={} ", "elasticsearch-conf.properties");
        }

        Preconditions.checkNotNull(properties ,"loader file error elasticsearch-conf.properties");
        Preconditions.checkArgument(properties.size()!=0," config file not null");
        logger.info("load properties end..");
        logger.info("check parameter begin ..");
        String name=  properties.getProperty("cluster.name");
        String ipandports= properties.getProperty("cluster.ipandports");
        String index=  properties.getProperty("cluster.index");
        String type=properties.getProperty("cluster.type");
        Preconditions.checkNotNull(name,"cluster.name null");

        Preconditions.checkNotNull(ipandports,"cluster.ipandports null");
        Preconditions.checkNotNull(index,"cluster.index null");
        Preconditions.checkNotNull(type,"cluster.type null");
        logger.info("check parameter end ..");
    }



    @After
    @Override
    public void destory() {
        logger.info("end");
    }
}
