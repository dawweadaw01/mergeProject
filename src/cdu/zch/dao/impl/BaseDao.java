package cdu.zch.dao.impl;

import java.sql.*;

// 只需要写操作数据库的代码
public class BaseDao {

    //连接数据库，添加用户
    String driver = "com.mysql.cj.jdbc.Driver";
    //注意url需要手动设置时区
    String url = "jdbc:mysql://localhost:3306/javawebProject?setServerTimeZone";  //serverTimezone=Asia/Shanghai
    String dbUserName = "root";
    String dbPwd = "123456";

    protected Connection conn = null;

    protected Statement stmt = null;

    protected PreparedStatement pstmt = null;

    protected ResultSet rs = null;

    public BaseDao() {
        connet();
    }

    // 数据库的连接操作
    void connet() {
        try {
            //加载驱动程序
            Class.forName(driver).newInstance();
            //创建数据库连接
            conn = DriverManager.getConnection(url, dbUserName, dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void close() {
        try {
            if (rs != null && rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && stmt.isClosed()) {
                stmt.close();
            }
            if (pstmt != null && pstmt.isClosed()) {
                pstmt.close();
            }
            if (conn != null && conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
