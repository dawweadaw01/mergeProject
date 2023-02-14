package cdu.lhj.service.impl;

import cdu.lhj.dao.CommentDao;
import cdu.lhj.dao.impl.CommentDaoImpl;
import cdu.lhj.model.Comment;
import cdu.lhj.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao=new CommentDaoImpl();
    @Override
    public int addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public int deleteComment(int id) {
        return commentDao.deleteComment(id);
    }

    @Override
    public List<Comment> getComment(int comicId) {
        return commentDao.getComment(comicId);
    }
}
