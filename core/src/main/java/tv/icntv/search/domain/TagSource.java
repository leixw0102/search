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

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/11/18
 * Time: 14:10
 */
public class TagSource {
    private  long id;
    private int tagLevel;//1,2
    private String tagName;
    private TagSource[]childTagSource;

    public TagSource[] getChildTagSource() {
        return childTagSource;
    }

    public void setChildTagSource(TagSource[] childTagSource) {
        this.childTagSource = childTagSource;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getTagLevel() {
        return tagLevel;
    }

    public void setTagLevel(int tagLevel) {
        this.tagLevel = tagLevel;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
