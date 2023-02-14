package cdu.lhj.controller;

import cdu.lhj.model.Comic;
import cdu.lhj.service.ComicService;
import cdu.lhj.service.impl.ComicServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/comic/findById")
public class ComicByIdServlet extends HttpServlet {

    ComicService comicService = new ComicServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        Comic comic = comicService.getComicById(Integer.parseInt(id));

        String json = new Gson().toJson(comic);
//        System.out.println(json);
        if(json != null){
            out.write(json);
        }else{
            out.write("false");
        }

    }
}
