package cdu.zch.dao.impl;

import cdu.zch.dao.NewsDao;
import cdu.zch.model.News;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {

    @Override
    public News get(int id) {
        News news = null;
        String sql = "SELECT * FROM news_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setAuthor(rs.getString("author"));
                news.setSource(rs.getString("source"));
                news.setTextContent(rs.getString("textContent"));
                news.setImgCover(rs.getString("imgCover"));
                news.setCreatTime(rs.getString("creatTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public News findById(int id) {
        News news = null;
        String sql = "SELECT * FROM news_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setAuthor(rs.getString("author"));
                news.setSource(rs.getString("source"));
                news.setTextContent(rs.getString("textContent"));
                news.setImgCover(rs.getString("imgCover"));
                news.setCreatTime(rs.getString("creatTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public List<News> findAll() {
        List<News> newsList = new ArrayList<>();
        String sql = "SELECT * FROM news_table";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setAuthor(rs.getString("author"));
                news.setSource(rs.getString("source"));
                news.setTextContent(rs.getString("textContent"));
                news.setImgCover(rs.getString("imgCover"));
                news.setCreatTime(rs.getString("creatTime"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    @Override
    public List<News> findByPage(int pageNum, int pageSize) {
        List<News> newsList = new ArrayList<>();
        String sql = "SELECT * FROM news_table ORDER BY creatTime DESC LIMIT ?,?";//按照创建时间降序
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNum - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("id"));
                news.setTitle(rs.getString("title"));
                news.setAuthor(rs.getString("author"));
                news.setSource(rs.getString("source"));
                news.setTextContent(rs.getString("textContent")); // ??????????????
                news.setImgCover(rs.getString("imgCover"));
                news.setCreatTime(rs.getString("creatTime"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public int count() {
        int count = 0;
        String sql = "SELECT count(*) FROM news_table";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int addMsg(News news) {
        int rows = 0;
        String sql = "INSERT INTO news_table(title,author,source,textContent,imgCover,creatTime) value(?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, news.getTitle());
            pstmt.setString(2, news.getAuthor());
            pstmt.setString(3, news.getSource());
            pstmt.setString(4, news.getTextContent());
            pstmt.setString(5, news.getImgCover());
            pstmt.setString(6, news.getCreatTime());

            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateMsg(News news) {
        int rows = 0;
        String sql = "UPDATE news_table SET title=?,author=?,source=?,textContent=?,imgCover=?,creatTime=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, news.getTitle());//标题
            pstmt.setString(2, news.getAuthor());//作者
            pstmt.setString(3, news.getSource());//来源你
            pstmt.setString(4, news.getTextContent());//文本内容
            pstmt.setString(5, news.getImgCover());//封面
            pstmt.setString(6, news.getCreatTime());//创建时间
            pstmt.setInt(7, news.getId());//判定id
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateMsg(int id) {
        int rows = 0;
        String sql = "UPDATE news_table SET WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    @Override
    public int deleteMsg(int id) {
        int rows = 0;
        String sql = "DELETE FROM news_table WHERE id=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
