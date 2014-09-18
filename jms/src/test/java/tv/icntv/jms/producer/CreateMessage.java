package tv.icntv.jms.producer;/*
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

import org.apache.activemq.pool.PooledConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/18
 * Time: 15:15
 */
public class CreateMessage {
    ApplicationContext context = null;
    JmsTemplate template=null;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("applicationContext-producer.xml");
        template = context.getBean(JmsTemplate.class);
    }

    @Test
    public void testSend(){
        template.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                   return session.createTextMessage("hello word!");
            };
        });
    }

    @After
    public void destory(){
        template=null;
        PooledConnectionFactory factory=context.getBean(PooledConnectionFactory.class);
        factory.stop();
        context=null;
    }

}
