package cdu.zch.controller;

import cdu.zch.model.Admin;
import cdu.zch.model.User;
import cdu.zch.service.UserService;
import cdu.zch.service.impl.UserServiceImpl;
import cdu.zch.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage/admin")
public class ListAdminServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // 得到总数据条数
        int count = userService.countAdmin();
        PageInfo<Admin> pageInfo = new PageInfo<>();
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
        List<Admin> adminList = userService.selectAllAdmin(currentPage, pageSize);

        // 渲染到页面上
        req.setAttribute("adminList", adminList);

        // 计算出总页面数，设置到页面上
        pageInfo.setCount(count);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(currentPage);
        req.setAttribute("pageInfo",pageInfo);

        req.getRequestDispatcher("admin_manage.do").forward(req, resp);
    }
}
