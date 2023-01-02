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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/comic/search")
public class ComicSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session=req.getSession();
        String value=req.getParameter("keywords");
        String value1=null;
        if (value!=null&&!value.equals("")){
            value1=value;
            session.setAttribute("keywords",value1);
        }
        if (session.getAttribute("keywords")!=null&&!session.getAttribute("keywords").equals("")){
            value1= (String) session.getAttribute("keywords");
        }
//        System.out.println(value1);
//        System.out.println(value);
        ComicService comicService=new ComicServiceImpl();
        String sPage = req.getParameter("page");
        int page = 1;
        int pageSize = 5;
        if (sPage != null && !sPage.equals("")) {
            page = Integer.parseInt(sPage);
        }
        int count = comicService.searchCount(value1);
        int pageCount = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;
        List<Comic> comicList=comicService.searchComic(page,pageSize,value1);
        req.setAttribute("comicList",comicList);
//        System.out.println(comicList);
        req.setAttribute("page", page);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("count", count);

        String json = new Gson().toJson(comicList);
        out.write(json);

//        req.getRequestDispatcher("search.do").forward(req,resp);
    }
}
