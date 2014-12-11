package tv.icntv.cms.response;/*
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

import tv.icntv.cms.response.searchvo.Tag;

import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/09/16
 * Time: 15:24
 */
public  class Msg {
    private long total;
    private int pageNo=1;
    private int limit = 20;

    private List list;
    private List<Tag> primary_tag;

    public List<Tag> getPrimary_tag() {
        return primary_tag;
    }

    public void setPrimary_tag(List<Tag> primary_tag) {
        this.primary_tag = primary_tag;
    }

    public Msg(int limit, int pageNo, long total) {
        this.limit = limit;
        this.pageNo = pageNo;
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "limit=" + limit +
                ", total=" + total +
                ", pageNo=" + pageNo +
                ", list=" + list +
                ", primary_tag=" + primary_tag +
                '}';
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
