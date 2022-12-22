package cdu.zch.model;

import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String avatar;
    private String email;
    private String phone;
    private long createTime;
    private String[] collection; //收藏是存放的动漫id
    private String[] history;   //与收藏同理

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", collection=" + Arrays.toString(collection) +
                ", history=" + Arrays.toString(history) +
                '}';
    }

    public User(int id, String userName, String password, String avatar, String email, String phone, long createTime, String[] collection, String[] history) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
        this.collection = collection;
        this.history = history;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getCollection() {
        return collection;
    }

    public void setCollection(String[] collection) {
        this.collection = collection;
    }

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }

    public User() {
    }
}
