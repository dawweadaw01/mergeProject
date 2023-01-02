package cdu.zch.controller;

import cdu.zch.model.Comic;
import cdu.zch.model.ComicAndComment;
import cdu.zch.model.Comment;
import cdu.zch.service.ComicService;
import cdu.zch.service.CommentService;
import cdu.zch.service.UserService;
import cdu.zch.service.impl.ComicServiceImpl;
import cdu.zch.service.impl.CommentServiceImpl;
import cdu.zch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/comic/detail")
public class ComicDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取动漫id
        String id = req.getParameter("id");
        ComicService comicService = new ComicServiceImpl();
        CommentService commentService = new CommentServiceImpl();
        UserService userService=new UserServiceImpl();
        // UserService userService=new UserServiceImpl();
        //根据id查找到相应动漫和评论内容
        Comic comic = comicService.getComicById(Integer.parseInt(id));
        List<Comment> commentList = commentService.getComment(Integer.parseInt(id));
        List<Comic> comicList = comicService.getIndexComic();  // 动漫榜单
        //实例化user
        for(Comment list:commentList){
                list.setReviewer(userService.selectByUserId(list.getUserId()));
                list.setReviewerTo(userService.selectByUserId(list.getOtherId()));
        }
//        ComicAndComment comicAndComment = new ComicAndComment(comic,commentList);
//        req.setAttribute("detailList",comicAndComment);
        req.setAttribute("comic", comic);
        req.setAttribute("commentList", commentList);
        req.setAttribute("comicList", comicList);
//        System.out.println(commentList);
        req.getRequestDispatcher("/comic/comic_info.do").forward(req,resp);
    }
}
