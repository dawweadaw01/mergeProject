package cdu.lhj.dao;

import cdu.lhj.model.Comment;

import java.util.List;

public interface CommentDao {
    //获取评论
    List<Comment> getComment(int comicId);
    //增加评论
    int addComment(Comment comment);
    //删除评论
    int deleteComment(int id);
}
