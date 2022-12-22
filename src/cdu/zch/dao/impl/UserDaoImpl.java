package cdu.zch.dao.impl;

import cdu.zch.dao.UserDao;
import cdu.zch.model.Admin;
import cdu.zch.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DAO程核心方法
 * 用于实现数据库的增删改查
 * 用法请看接口
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int insert(User user) {
        int rows = 0;
        String sql = "INSERT INTO user_table(userName,password,avatar,email,phone,createTime) VALUES(?,?,?,?,?,?)";
        System.out.println("DAO 插入用户: " + user);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getAvatar());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());
            pstmt.setLong(6, user.getCreateTime());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DAO 添加用户失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User login(String name, String password) {
        User user = null;
        String sql = "SELECT * FROM user_table WHERE userName=? AND password=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCreateTime(rs.getLong("createTime"));
                String collection = rs.getString("collection");
                if (collection != null) {
                    String[] collections = collection.split("_");
                    user.setCollection(collections);
                } else {
                    user.setCollection(new String[0]);
                }
                String browseRecords = rs.getString("history");
                if (browseRecords != null) {
                    String[] browseRecord = browseRecords.split("_");
                    user.setHistory(browseRecord);
                } else {
                    user.setHistory(new String[0]);
                }
            }
        } catch (SQLException e) {
            System.out.println("DAO 获取登录用户失败：name=" + name + ", password=" + password);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateHistory(User user, String comicId) {
        int rows = 0;
        String sql = "UPDATE user_table SET history=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            String[] history = user.getHistory();
            boolean contains = Arrays.asList(history).contains(comicId);
            if (contains || comicId == null) {
                return 0;
            } else {
                StringBuilder stringBuffer = new StringBuilder();
                for (int i = 0; i < history.length; i++) {
                    stringBuffer.append(history[i]);
                    stringBuffer.append("_");
                }
                stringBuffer.append(comicId);
                pstmt.setString(1, stringBuffer.toString());
                pstmt.setInt(2, user.getId());
                rows = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("DAO 修改用户失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public User selectByUserId(int id) {
        User user = null;
        String sql = "SELECT * FROM user_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCreateTime(rs.getLong("createTime"));
                String collection = rs.getString("collection");
                if (collection != null) {
                    String[] collections = collection.split("_");
                    user.setCollection(collections);
                } else {
                    user.setCollection(new String[0]);
                }
                String historys = rs.getString("history");
                if (historys != null) {
                    String[] history = historys.split("_");
                    user.setHistory(history);
                } else {
                    user.setHistory(new String[0]);
                }
            }
        } catch (SQLException e) {
            System.out.println("DAO 获取用户失败: id=" + id);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateCollection(User user, String comicId) {
        int rows = 0;
        String sql = "UPDATE user_table SET collection=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            String[] collection = user.getCollection();
            boolean contains = Arrays.asList(collection).contains(comicId);
            if (contains || comicId == null) {
                return 0;
            } else {
                StringBuilder stringBuffer = new StringBuilder();
                for (int i = 0; i < collection.length; i++) {
                    stringBuffer.append(collection[i]);
                    stringBuffer.append("_");
                }
                stringBuffer.append(comicId);
                pstmt.setString(1, stringBuffer.toString());
                pstmt.setInt(2, user.getId());
                rows = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("DAO 修改用户失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Admin loginAdmin(String adminName, String password) {
        Admin admin = null;
        String sql = "SELECT * FROM admin_table WHERE adminName=? AND password=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
                admin.setDefault_avatar(rs.getString("default_avatar"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin;
    }

    @Override
    public int delete(int id) {
        int rows = 0;
        String sql = "DELETE FROM user_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(User user) {
        int rows = 0;
        String sql = "UPDATE user_table SET userName=?,password=?,avatar=?,email=?,phone=? WHERE id=?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getAvatar());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());
//            pstmt.setLong(6, user.getCreateTime());
//            StringBuilder collection = new StringBuilder();
//            for (int i = 0; i < user.getCollection().length; i++) {
//                collection.append(user.getCollection()[i]);
//                collection.append("_");
//            }
//            pstmt.setString(7, collection.toString());
//            StringBuilder history = new StringBuilder();
//            for (int i = 0; i < user.getHistory().length; i++) {
//                history.append(user.getHistory()[i]);
//                history.append("_");
//            }
//            pstmt.setString(8, history.toString());
            pstmt.setInt(6, user.getId());

            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DAO 更改用户失败");
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public List<User> selectByName(String adminName) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user_table WHERE userName LIKE ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + adminName + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userNae"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCreateTime(rs.getLong("createTime"));
                String collection = rs.getString("collection");
                if (collection != null) {
                    String[] collections = collection.split("_");
                    user.setCollection(collections);
                } else {
                    user.setCollection(new String[0]);
                }
                String historys = rs.getString("history");
                if (historys != null) {
                    String[] history = historys.split("_");
                    user.setHistory(history);
                } else {
                    user.setHistory(new String[0]);
                }
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int countUser() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM user_table";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<User> selectAllUser(int pageNum, int pageSize) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user_table LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNum - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCreateTime(rs.getLong("createTime"));
                String collection = rs.getString("collection");
                if (collection != null) {
                    String[] collections = collection.split("_");
                    user.setCollection(collections);
                } else {
                    user.setCollection(new String[0]);
                }
                String historys = rs.getString("history");
                if (historys != null) {
                    String[] history = historys.split("_");
                    user.setHistory(history);
                } else {
                    user.setHistory(new String[0]);
                }
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int countAdmin() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM admin_table";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Admin> selectAllAdmin(int pageNum, int pageSize) {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM admin_table LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNum - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
                admin.setDefault_avatar(rs.getString("default_avatar"));
                admins.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }
}