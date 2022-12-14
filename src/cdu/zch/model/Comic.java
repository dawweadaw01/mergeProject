package cdu.zch.model;

import java.io.Serializable;

public class Comic implements Serializable {

    private int id;
    private String comicName;
    private String nickname;
    private String cover;
    private String region;
    private String label;
    private String description;
    private String remark;
    private String year;
    private String updateTime;
    private int number;
    private int popularity;
    private String url;

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", comicName='" + comicName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", cover='" + cover + '\'' +
                ", region='" + region + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", remark='" + remark + '\'' +
                ", year='" + year + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", number=" + number +
                ", popularity=" + popularity +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Comic(int id, String comicName, String nickname, String cover, String region, String label, String description, String remark, String year, String updateTime, int number, int popularity, String url) {
        this.id = id;
        this.comicName = comicName;
        this.nickname = nickname;
        this.cover = cover;
        this.region = region;
        this.label = label;
        this.description = description;
        this.remark = remark;
        this.year = year;
        this.updateTime = updateTime;
        this.number = number;
        this.popularity = popularity;
        this.url = url;
    }

    public Comic() {
    }

    public Comic(int id, String comicName, String nickname, String cover, String region, String label, String description, String remark, String year, String updateTime, int number, int popularity) {
        this.id = id;
        this.comicName = comicName;
        this.nickname = nickname;
        this.cover = cover;
        this.region = region;
        this.label = label;
        this.description = description;
        this.remark = remark;
        this.year = year;
        this.updateTime = updateTime;
        this.number = number;
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
