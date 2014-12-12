package tv.icntv.search.domain;/*
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
import tv.icntv.search.elastic.Index;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/12/11
 * Time: 14:01
 */
public enum  MsgStatus {
    ONLINE {
        @Override
        public boolean operation(ProgramSeries programSeries) {
            return index.createIndex(programSeries);  //To change body of implemented methods use File | Settings | File Templates.
        }
    }, OFFLINE {
        @Override
        public boolean operation(ProgramSeries programSeries) {
            return index.deleteIndex(programSeries);  //To change body of implemented methods use File | Settings | File Templates.
        }
    },ONLINETOONLINE {
        @Override
        public boolean operation(ProgramSeries programSeries) {
            return index.update(programSeries);  //To change body of implemented methods use File | Settings | File Templates.
        }
    };
    Index index = new Index();
    public abstract boolean operation(ProgramSeries programSeries);
}
