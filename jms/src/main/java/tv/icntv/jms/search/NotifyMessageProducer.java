package tv.icntv.jms.search;/*
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tv.icntv.search.domain.JmsData;
import tv.icntv.search.domain.MsgStatus;
import tv.icntv.search.domain.ProgramSeries;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by leixw
 * 接收cms发送的消息，根据不同的动作进行处理
 * <p/>
 * Author: leixw
 * Date: 2014/09/18
 * Time: 14:14
 */
public class NotifyMessageProducer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onMessage(Message message) {

        if (message instanceof TextMessage) {
            TextMessage msg = (TextMessage) message;

            JmsData jmsData = null;
            try {
                if (logger.isDebugEnabled()) {
                    logger.debug("jms msg ={}", msg.getText());
                }
                jmsData = JSON.parseObject(msg.getText(), JmsData.class);
            } catch (JMSException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            boolean result = MsgStatus.valueOf(jmsData.getActive().toUpperCase()).operation(jmsData.getData());
            logger.info(" jms received msg by TextMessage ,and msg active={},operation result = {}", jmsData.getActive(), result);


        } else {
            logger.error("error message type");
        }

        //To change body of implemented methods use File | Settings | File Templates.
    }
}
