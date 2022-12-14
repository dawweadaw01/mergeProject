package cdu.zch.model;

import java.io.Serializable;

public class Admin implements Serializable {
    private int id;
    private String adminName;
    private String password;
    private String default_avatar; //管理员头像默认

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", default_avatar='" + default_avatar + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDefault_avatar() {
        return default_avatar;
    }

    public void setDefault_avatar(String default_avatar) {
        this.default_avatar = default_avatar;
    }

    public Admin() {
    }

    public Admin(int id, String adminName, String password, String default_avatar) {
        this.id = id;
        this.adminName = adminName;
        this.password = password;
        this.default_avatar = default_avatar;
    }
}
