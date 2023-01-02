package cdu.zch.dao.impl;

import cdu.zch.dao.ComicDao;
import cdu.zch.model.Comic;
import cdu.zch.model.News;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComicDaoImpl extends BaseDao implements ComicDao {
    @Override
    public int addComic(Comic comic) {
        int result;
        String sql="insert into comic_table(comicName, nickname, cover, region, label, description, remark, year, updateTime, number, popularity,url) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            insert(comic, sql);
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("上传失败");
            throw new RuntimeException(e);
        }
        return result;
    }

    private void insert(Comic comic, String sql) throws SQLException {
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,comic.getComicName());
        pstmt.setString(2,comic.getNickname());
        pstmt.setString(3,comic.getCover());
        pstmt.setString(4,comic.getRegion());
        pstmt.setString(5,comic.getLabel());
        pstmt.setString(6,comic.getDescription());
        pstmt.setString(7,comic.getRemark());
        pstmt.setString(8,comic.getYear());
        pstmt.setString(9,comic.getUpdateTime());
        pstmt.setInt(10,comic.getNumber());
        pstmt.setInt(11,comic.getPopularity());
        pstmt.setString(12,comic.getUrl());
    }

    @Override
    public List<Comic> getComic(String region) {
        List<Comic> comicList= new ArrayList<>();
        String sql = "SELECT * FROM comic_table WHERE region=? ORDER BY id";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,region);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Comic comic = new Comic();
                    comic.setId(rs.getInt("id"));
                    comic.setComicName(rs.getString("comicName"));
                    comic.setNickname(rs.getString("nickname"));
                    comic.setCover(rs.getString("cover"));
                    comic.setRegion(rs.getString("region"));
                    comic.setLabel(rs.getString("label"));
                    comic.setDescription(rs.getString("description"));
                    comic.setRemark(rs.getString("remark"));
                    comic.setYear(rs.getString("year"));
                    comic.setUpdateTime(rs.getString("updateTime"));
                    comic.setNumber(rs.getInt("number"));
                    comic.setPopularity(rs.getInt("popularity"));
                    comic.setUrl(rs.getString("url"));
                    comicList.add(comic);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return comicList;
    }
    @Override
    public int count(int region) {
        int bcount = 0;
        String sql;
        if (region==0){
            sql = "SELECT count(*) FROM comic_table";
        }else {
            sql = "SELECT count(region)  FROM comic_table WHERE region=?";
        }
        try {
            if (region==0){
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
            }else {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,region);
                rs = pstmt.executeQuery();
            }
            while (rs.next()) {
                bcount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bcount;
    }

    @Override
    public List<Comic> getIndexComic() {
        List<Comic> comicList=new ArrayList<>();
        String sql="SELECT * FROM comic_table order by number desc limit 10";
        try {
            pstmt = conn.prepareStatement(sql);
            getComic(comicList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comicList;
    }

    private void getComic(List<Comic> comicList) throws SQLException {
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Comic comic = new Comic();
            comic.setId(rs.getInt("id"));
            comic.setComicName(rs.getString("comicName"));
            comic.setNickname(rs.getString("nickname"));
            comic.setCover(rs.getString("cover"));
            comic.setRegion(rs.getString("region"));
            comic.setLabel(rs.getString("label"));
            comic.setDescription(rs.getString("description"));
            comic.setRemark(rs.getString("remark"));
            comic.setYear(rs.getString("year"));
            comic.setUpdateTime(rs.getString("updateTime"));
            comic.setNumber(rs.getInt("number"));
            comic.setPopularity(rs.getInt("popularity"));
            comic.setUrl(rs.getString("url"));
            comicList.add(comic);
        }
    }

    @Override
    public Comic getComicById(int id) {
        Comic comic=null;
        String sql="SELECT * FROM comic_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                comic = new Comic();
                comic.setId(rs.getInt("id"));
                comic.setComicName(rs.getString("comicName"));
                comic.setNickname(rs.getString("nickname"));
                comic.setCover(rs.getString("cover"));
                comic.setRegion(rs.getString("region"));
                comic.setLabel(rs.getString("label"));
                comic.setDescription(rs.getString("description"));
                comic.setRemark(rs.getString("remark"));
                comic.setYear(rs.getString("year"));
                comic.setUpdateTime(rs.getString("updateTime"));
                comic.setNumber(rs.getInt("number"));
                comic.setPopularity(rs.getInt("popularity"));
                comic.setUrl(rs.getString("url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comic;
    }

    @Override
    public int updateComic(Comic comic) {
       int result=0;
       String sql="UPDATE comic_table SET comicName=?,nickname=?,cover=?,region=?,label=?,description=?,remark=?,year=?,updateTime=?,number=?,popularity=?,url=? WHERE id=?";
       try {
           insert(comic, sql);
           pstmt.setInt(13,comic.getId());
           result=pstmt.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return result;
    }

    @Override
    public int deleteComic(int id) {
       int result=0;
        String sql="DELETE FROM comic_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Comic> searchComic(int first, int last,String comicName) {
        List<Comic> comicList=new ArrayList<>();
        String sql = "SELECT * FROM comic_table WHERE comicName LIKE ? ORDER BY id LIMIT ?,?";
        try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+comicName+"%");
                pstmt.setInt(2, first);
                pstmt.setInt(3, last);
            getComic(comicList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comicList;
    }

    @Override
    public int searchCount(String comicName) {
        int searchCount=0;
        String sql="SELECT count(*)  FROM comic_table WHERE comicName LIKE ? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+comicName+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                searchCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchCount;
    }

    @Override
    public int count() {
        int count = 0;
        String sql = "SELECT count(*) FROM comic_table";
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
    public List<Comic> selectAllComic(int pageNum, int pageSize) {
        List<Comic> comicList = new ArrayList<>();
        String sql = "SELECT * FROM comic_table LIMIT ?,?";//按照创建时间降序
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNum - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Comic comic = new Comic();
                comic.setId(rs.getInt("id"));
                comic.setComicName(rs.getString("comicName"));
                comic.setNickname(rs.getString("nickname"));
                comic.setCover(rs.getString("cover"));
                comic.setRegion(rs.getString("region"));
                comic.setLabel(rs.getString("label"));
                comic.setDescription(rs.getString("description"));
                comic.setRemark(rs.getString("remark"));
                comic.setYear(rs.getString("year"));
                comic.setUpdateTime(rs.getString("updateTime"));
                comic.setNumber(rs.getInt("number"));
                comic.setPopularity(rs.getInt("popularity"));
                comic.setUrl(rs.getString("url"));
                comicList.add(comic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comicList;
    }
}
