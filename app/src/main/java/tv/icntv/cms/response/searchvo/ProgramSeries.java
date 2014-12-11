package tv.icntv.cms.response.searchvo;/*
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
 * Time: 15:30
 */
public class ProgramSeries {
    private long program_series_id;
    private String program_series_name=null;
    private String poster=null;
    private String program_series_en_name=null;
    private String program_series_header=null;
    private String small_poster_addr=null;
    private String big_poster_addr=null;
    private String program_series_desc=null;
    private int year;
    private int is3d;
    private int time_length;
    private int is_customer;

    private String star_rating;
//    private String action;//????
//    private String tags[];
    private CornerMark cornerMark=new CornerMark();

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

    public int getTime_length() {
        return time_length;
    }

    public int getIs3d() {
        return is3d;
    }

    public void setIs3d(int is3d) {
        this.is3d = is3d;
    }

    public int getIs_customer() {
        return is_customer;
    }

    public void setIs_customer(int is_customer) {
        this.is_customer = is_customer;
    }

    public String getProgram_series_en_name() {
        return program_series_en_name;
    }

    public void setProgram_series_en_name(String program_series_en_name) {
        this.program_series_en_name = program_series_en_name;
    }

    public String getProgram_series_header() {
        return program_series_header;
    }

    public void setProgram_series_header(String program_series_header) {
        this.program_series_header = program_series_header;
    }

    @Override
    public String toString() {
        return "ProgramSeries{" +
                "big_poster_addr='" + big_poster_addr + '\'' +
                ", program_series_id=" + program_series_id +
                ", program_series_name='" + program_series_name + '\'' +
                ", poster='" + poster + '\'' +
                ", program_series_en_name='" + program_series_en_name + '\'' +
                ", program_series_header='" + program_series_header + '\'' +
                ", small_poster_addr='" + small_poster_addr + '\'' +
                ", program_series_desc='" + program_series_desc + '\'' +
                ", year=" + year +
                ", is3d=" + is3d +
                ", time_length=" + time_length +
                ", is_customer=" + is_customer +

                ", star_rating='" + star_rating + '\'' +
                ", cornerMark=" + cornerMark +
                '}';
    }

    public long getProgram_series_id() {
        return program_series_id;
    }

    public void setProgram_series_id(long program_series_id) {
        this.program_series_id = program_series_id;
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
