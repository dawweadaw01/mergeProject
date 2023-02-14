package cdu.lhj.controller;

import cdu.lhj.model.News;
import cdu.lhj.service.NewsService;
import cdu.lhj.service.impl.NewsServiceImpl;
import cdu.lhj.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage/news")
public class NewsListServlet extends HttpServlet {

    NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // 得到总数据条数
        int count = newsService.count();
        PageInfo<News> pageInfo = new PageInfo<>();
        // 得到当前页数
        String cPage = req.getParameter("currentPage");
        if(cPage == null || "".equals(cPage)){
            cPage = "1";
        }
        int currentPage = Integer.parseInt(cPage);

        // 得到每页最大数据数
        String sPageSize = req.getParameter("pageSize");
        if(sPageSize == null || "".equals(sPageSize)){
            sPageSize = "5";
        }
        int pageSize = Integer.parseInt(sPageSize);

        // 得到分页查询的数据
        List<News> newsList = newsService.findByPage(currentPage, pageSize);

        // 渲染到页面上
        req.setAttribute("newsList", newsList);

        // 计算出总页面数，设置到页面上
        pageInfo.setCount(count);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(currentPage);
        req.setAttribute("pageInfo",pageInfo);
        int[] arr = new int[pageInfo.getPageNum()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        req.setAttribute("arr", arr);

        req.getRequestDispatcher("news_manage.do").forward(req, resp);
    }
}
