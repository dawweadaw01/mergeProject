package cdu.zch.controller;

import cdu.zch.service.ComicService;
import cdu.zch.service.impl.ComicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comic/delete")
public class ComicDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        ComicService comicService=new ComicServiceImpl();
        if (comicService.delComic(Integer.parseInt(id))==1){
            resp.sendRedirect("list");
        }else {
            System.out.println("没删除");
        }
    }
}
