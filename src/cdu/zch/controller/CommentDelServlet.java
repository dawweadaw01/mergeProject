package cdu.zch.controller;

import cdu.zch.service.CommentService;
import cdu.zch.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/comic/delComment")
public class CommentDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String id=req.getParameter("id");
        CommentService commentService=new CommentServiceImpl();
        if (commentService.deleteComment(Integer.parseInt(id))==1){
            out.write("true");
//            resp.sendRedirect("list");
        }else {
            out.write("false");
//            System.out.println("没删除");
        }
    }

}
