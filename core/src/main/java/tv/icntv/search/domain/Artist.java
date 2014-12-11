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
 * Time: 14:32
 */
public class Artist {
    private int id;
    private String headUrl;
    private String birthday;
    private String constellation;
    private int sex;
    private int artistWeight;
    private String alias;
    private String profession;
    private String repWorks;
    private String bloodType;
    private String enName;
    private String graduateSchool;
    private String birthPlace;
    private String nation;
    private int artistHeight;
    private String nationality;
    private String stageName;
    private String praName;
    private String spouse;
    private String brokerageFirm;//经纪公司
    private String artistDesc;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getArtistDesc() {
        return artistDesc;
    }

    public void setArtistDesc(String artistDesc) {
        this.artistDesc = artistDesc;
    }

    public int getArtistHeight() {
        return artistHeight;
    }

    public void setArtistHeight(int artistHeight) {
        this.artistHeight = artistHeight;
    }

    public int getArtistWeight() {
        return artistWeight;
    }

    public void setArtistWeight(int artistWeight) {
        this.artistWeight = artistWeight;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBrokerageFirm() {
        return brokerageFirm;
    }

    public void setBrokerageFirm(String brokerageFirm) {
        this.brokerageFirm = brokerageFirm;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPraName() {
        return praName;
    }

    public void setPraName(String praName) {
        this.praName = praName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRepWorks() {
        return repWorks;
    }

    public void setRepWorks(String repWorks) {
        this.repWorks = repWorks;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}
