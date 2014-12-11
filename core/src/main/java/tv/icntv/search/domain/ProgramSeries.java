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
 * Date: 2014/11/14
 * Time: 15:06
 */
public class ProgramSeries {
    private long id;
    private String programSeriesName;
    private String programSeriesEnName;
    private String programSeriesDesc;
    private String programPinyin;
    private int programLength;
    private int is3d;

    public int getIs3d() {
        return is3d;
    }

    public void setIs3d(int is3d) {
        this.is3d = is3d;
    }

    public int getProgramLength() {
        return programLength;
    }

    public void setProgramLength(int programLength) {
        this.programLength = programLength;
    }

    private String programHeader;
    private int programTotalCount;
    private String zone;
    private String[]copyRightZone;
    private String[] platformName;
    private TagSource[] tags;//
    private Program[] programs;//
    private Artist[] artists;//
    private String publishDate;
    private float grade;
    private int isCustomer;
    private String bigPosterAddr;
    private String smallPosterAddr;
    private String posterAddr;
    private String sendJMSTime;
    private String year;

    public String getSendJMSTime() {
        return sendJMSTime;
    }

    public void setSendJMSTime(String sendJMSTime) {
        this.sendJMSTime = sendJMSTime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String[] getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String[] platformName) {
        this.platformName = platformName;
    }

    public String getPosterAddr() {
        return posterAddr;
    }

    public void setPosterAddr(String posterAddr) {
        this.posterAddr = posterAddr;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public void setArtists(Artist[] artists) {
        this.artists = artists;
    }

    public String getBigPosterAddr() {
        return bigPosterAddr;
    }

    public void setBigPosterAddr(String bigPosterAddr) {
        this.bigPosterAddr = bigPosterAddr;
    }

    public String[] getCopyRightZone() {
        return copyRightZone;
    }

    public void setCopyRightZone(String[] copyRightZone) {
        this.copyRightZone = copyRightZone;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCustomer() {
        return isCustomer;
    }

    public void setCustomer(int customer) {
        isCustomer = customer;
    }

    public String getProgramHeader() {
        return programHeader;
    }

    public void setProgramHeader(String programHeader) {
        this.programHeader = programHeader;
    }

    public String getProgramPinyin() {
        return programPinyin;
    }

    public void setProgramPinyin(String programPinyin) {
        this.programPinyin = programPinyin;
    }

    public Program[] getPrograms() {
        return programs;
    }

    public void setPrograms(Program[] programs) {
        this.programs = programs;
    }

    public String getProgramSeriesDesc() {
        return programSeriesDesc;
    }

    public void setProgramSeriesDesc(String programSeriesDesc) {
        this.programSeriesDesc = programSeriesDesc;
    }

    public String getProgramSeriesEnName() {
        return programSeriesEnName;
    }

    public void setProgramSeriesEnName(String programSeriesEnName) {
        this.programSeriesEnName = programSeriesEnName;
    }

    public String getProgramSeriesName() {
        return programSeriesName;
    }

    public void setProgramSeriesName(String programSeriesName) {
        this.programSeriesName = programSeriesName;
    }

    public int getProgramTotalCount() {
        return programTotalCount;
    }

    public void setProgramTotalCount(int programTotalCount) {
        this.programTotalCount = programTotalCount;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSmallPosterAddr() {
        return smallPosterAddr;
    }

    public void setSmallPosterAddr(String smallPosterAddr) {
        this.smallPosterAddr = smallPosterAddr;
    }

    public TagSource[] getTags() {
        return tags;
    }

    public void setTags(TagSource[] tags) {
        this.tags = tags;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
