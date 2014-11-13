package tv.icntv.search.domain.response.searchvo;/*
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
 * Date: 2014/09/16
 * Time: 15:30
 */
public class ProgramSeries {
    private int program_series_id;
    private String program_series_name;
    private String poster;
    private String small_poster_addr;
    private String big_poster_addr;
    private String program_series_desc;
    private int year;
    private boolean is3d;
    private int time_length;
    private boolean is_customer;
    private String star_rating;
    private String action;//????
    private String tags[];
    private CornerMark cornerMark;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBig_poster_addr() {
        return big_poster_addr;
    }

    public void setBig_poster_addr(String big_poster_addr) {
        this.big_poster_addr = big_poster_addr;
    }

    public CornerMark getCornerMark() {
        return cornerMark;
    }

    public void setCornerMark(CornerMark cornerMark) {
        this.cornerMark = cornerMark;
    }

    public boolean isIs3d() {
        return is3d;
    }

    public void setIs3d(boolean is3d) {
        this.is3d = is3d;
    }

    public boolean isIs_customer() {
        return is_customer;
    }

    public void setIs_customer(boolean is_customer) {
        this.is_customer = is_customer;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getProgram_series_desc() {
        return program_series_desc;
    }

    public void setProgram_series_desc(String program_series_desc) {
        this.program_series_desc = program_series_desc;
    }

    public int getProgram_series_id() {
        return program_series_id;
    }

    public void setProgram_series_id(int program_series_id) {
        this.program_series_id = program_series_id;
    }

    public String getProgram_series_name() {
        return program_series_name;
    }

    public void setProgram_series_name(String program_series_name) {
        this.program_series_name = program_series_name;
    }

    public String getSmall_poster_addr() {
        return small_poster_addr;
    }

    public void setSmall_poster_addr(String small_poster_addr) {
        this.small_poster_addr = small_poster_addr;
    }

    public String getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(String star_rating) {
        this.star_rating = star_rating;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int getTime_length() {
        return time_length;
    }

    public void setTime_length(int time_length) {
        this.time_length = time_length;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
