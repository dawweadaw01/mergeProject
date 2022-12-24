package cdu.zch.controller;

import cdu.zch.model.Comment;
import cdu.zch.service.CommentService;
import cdu.zch.service.impl.CommentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/comic/addComment")
public class CommentAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        CommentService commentService=new CommentServiceImpl();
        Comment comment=new Comment();
        //获取表单传的数据
        String userId=req.getParameter("userId");
        String otherId=req.getParameter("otherId");
        String comments=req.getParameter("comment");
        String comicId = req.getParameter("comicId");
        if (otherId!=null&&!otherId.equals("")){
            comment.setOtherId(Integer.parseInt(otherId));
        }
        comment.setUserId(Integer.parseInt(userId));
        comment.setComment(comments);
        comment.setComicId(Integer.parseInt(comicId));
        //获取当前时间
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cale = Calendar.getInstance();
        Date date= cale.getTime();//calendar 类型 转为 date类型
        String time=sim.format(date);
//        System.out.println(time);
        comment.setTime(time);
        if (commentService.addComment(comment)!=0){
            out.write("true");
//            resp.sendRedirect("detail");
        }else {
            out.write("false");
//            System.out.println("获取失败");
        }

    }
}
