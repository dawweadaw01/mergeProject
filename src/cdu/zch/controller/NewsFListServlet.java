package cdu.zch.controller;

import cdu.zch.model.News;
import cdu.zch.service.NewsService;
import cdu.zch.service.impl.NewsServiceImpl;
import cdu.zch.util.PageInfo;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/news/latest")
public class NewsFListServlet extends HttpServlet {

    NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        // 得到查询的数据
        List<News> newsList = newsService.findAll();

        Map<String, Object> map = new HashMap<>();
        map.put("newsList", newsList);
        String json = new Gson().toJson(map);
        if(json != null){
            out.write(json);
        }else{
            out.write("false");
        }

//        req.getRequestDispatcher("/news/news.do").forward(req, resp);
    }
}
