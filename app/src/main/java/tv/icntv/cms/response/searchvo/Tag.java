package tv.icntv.cms.response.searchvo;/*
 * Copyright 2014 Future TV, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */


import java.util.List;

/**
 * Created by leixw
 * <p/>
 * Author: leixw
 * Date: 2014/08/22
 * Time: 13:52
 */
public class Tag {
    private long count;
    private String name;
    private List<Tag> secondary_tag;

    public Tag() {
    }

    public Tag(long count, String name) {
        this.count = count;
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Tag> getSecondary_tag() {
        return secondary_tag;
    }

    public void setSecondary_tag(List<Tag> secondary_tag) {
        this.secondary_tag = secondary_tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", secondary_tag=" + secondary_tag +
                '}';
    }
}
