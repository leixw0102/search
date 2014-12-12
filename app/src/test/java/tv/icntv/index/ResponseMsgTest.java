package tv.icntv.index;/*
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

import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tv.icntv.cms.response.searchvo.ProgramSeries;
import tv.icntv.cms.response.searchvo.Tag;

import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 15:43
 */
public class ResponseMsgTest extends AbstractTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Before
    @Override
    public void init() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    @Test
    public void testSearchResponse(){
//        SearchMsg msg = new SearchMsg(10,1,40);
//        msg.setPrimary_tag(getPrimaryTag());
//        msg.setList(getProgramSeries());
//        Response response = new Response(msg,"success",0);
//        logger.info(JSON.toJSONString(response,true));
    }

    private List<ProgramSeries> getProgramSeries(){
        ProgramSeries programSeries1 = new ProgramSeries();
//        programSeries1.setAction("abc");
//        programSeries1.setBig_poster_addr("abcd");
//        programSeries1.setCornerMark(new CornerMark("a","b","c","d"));
//        programSeries1.setIs3d(false);
//        programSeries1.setPoster("deee");
//        programSeries1.setIs_customer(false);
//        programSeries1.setProgram_series_desc("eft");
//        programSeries1.setBig_poster_addr("kjl");
//        programSeries1.setProgram_series_id(10);
//        programSeries1.setProgram_series_name("dsf");
//        programSeries1.setSmall_poster_addr("sdkjfldsfsd");

        return Lists.newArrayList(programSeries1);
    }

    private List<Tag> getPrimaryTag(){
        Tag tag1 = new Tag();
//        tag1.setCount(20);
//        tag1.setName("电影");
//        List<SecondaryTag> secondaryTags= Lists.newArrayList(new SecondaryTag(10,"动作"),new SecondaryTag(10,"爱情"));
//        tag1.setSecondary_tag(secondaryTags);
//
        Tag tag2= new Tag(30,"电视剧");
//        tag2.setSecondary_tag(Lists.newArrayList(new SecondaryTag(20,"动作"),new SecondaryTag(10,"国内")));

        return Lists.newArrayList(tag1,tag2);
    }
    @After
    @Override
    public void destory() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
