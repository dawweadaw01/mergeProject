package cdu.zch.controller;

import cdu.zch.model.Comic;
import cdu.zch.service.ComicService;
import cdu.zch.service.impl.ComicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/comic/search")
public class ComicSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value=req.getParameter("value");
        System.out.println(value);
        ComicService comicService=new ComicServiceImpl();
        String sPage = req.getParameter("page");
        int page = 1;
        int pageSize = 5;
        if (sPage != null && !sPage.equals("")) {
            page = Integer.parseInt(sPage);
        }
        int count = comicService.searchCount(value);
        System.out.println(count);
        int pageCount = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;
        List<Comic> comicList=comicService.searchComic(page,pageSize,value);
    }
}
