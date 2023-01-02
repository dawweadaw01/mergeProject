package cdu.zch.dao.impl;

import cdu.zch.dao.CommentDao;
import cdu.zch.model.Comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public List<Comment> getComment(int comicId) {
        List<Comment> commentList=new ArrayList<>();
        String sql="SELECT * FROM comment where comicId=? order by time desc ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,comicId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Comment comment=new Comment();
                comment.setId(rs.getInt("id"));
                comment.setComicId(rs.getInt("comicId"));
                comment.setUserId(rs.getInt("userId"));
                comment.setOtherId(rs.getInt("otherId"));
                comment.setComment(rs.getString("comment"));
                comment.setTime(rs.getString("time"));
                commentList.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }

    @Override
    public int addComment(Comment comment) {
        int result=0;
        String sql="insert into comment(comicId, userId, otherId, comment, time) VALUES (?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,comment.getComicId());
            pstmt.setInt(2,comment.getUserId());
            pstmt.setInt(3,comment.getOtherId());
            pstmt.setString(4,comment.getComment());
            pstmt.setString(5,comment.getTime());
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int deleteComment(int id) {
        int result=0;
        String sql="DELETE FROM comment WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
