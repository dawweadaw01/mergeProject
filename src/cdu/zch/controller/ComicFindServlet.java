package cdu.zch.controller;

import cdu.zch.model.Comic;
import cdu.zch.service.ComicService;
import cdu.zch.service.impl.ComicServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class ComicFindServlet extends HttpServlet {

    ComicService comicService = new ComicServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String region = req.getParameter("region");
//        System.out.println(region);
        List<Comic> comicList = comicService.getComic(region);

        String json = new Gson().toJson(comicList);
        out.write(json);
    }
}
