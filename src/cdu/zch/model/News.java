package cdu.zch.model;

import java.io.Serializable;

public class News implements Serializable {
    private int id;//编号
    private String title;//标题
    private String author;//作者
    private String source;//来源
    private String textContent;//文本内容
    private String imgCover;//封面
    private String creatTime;//创建时间

    public News() {
    }

    public News(int id, String title, String author, String source, String textContent, String imgCover, String creatTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.source = source;
        this.textContent = textContent;
        this.imgCover = imgCover;
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", textContent='" + textContent + '\'' +
                ", imgCover='" + imgCover + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImgCover() {
        return imgCover;
    }

    public void setImgCover(String imgCover) {
        this.imgCover = imgCover;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }
}
