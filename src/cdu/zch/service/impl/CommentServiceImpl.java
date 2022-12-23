package cdu.zch.service.impl;

import cdu.zch.dao.CommentDao;
import cdu.zch.dao.impl.CommentDaoImpl;
import cdu.zch.model.Comment;
import cdu.zch.service.CommentService;

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
