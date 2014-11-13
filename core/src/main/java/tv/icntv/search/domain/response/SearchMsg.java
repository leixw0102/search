package tv.icntv.search.domain.response;/*
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

import java.util.List;


/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 15:02
 */
public  class SearchMsg extends ResponseBody{

    public SearchMsg(int limit, int pageNo, int total) {
        super(limit, pageNo, total);
    }

    public List getPrimary_tag() {
        return primary_tag;
    }

    public void setPrimary_tag(List primary_tag) {
        this.primary_tag = primary_tag;
    }

    private List primary_tag=null;

}
