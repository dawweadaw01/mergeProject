package cdu.lhj.controller;

import cdu.lhj.model.User;
import cdu.lhj.service.UserService;
import cdu.lhj.service.impl.UserServiceImpl;
import cdu.lhj.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage/user")
public class UserListServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        // 得到总数据条数
        int count = userService.countUser();
        PageInfo<User> pageInfo = new PageInfo<>();
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
        List<User> userList = userService.selectAllUser(currentPage, pageSize);

        // 渲染到页面上
        req.setAttribute("userList", userList);
        System.out.println(userList);

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

        req.getRequestDispatcher("user_manage.do").forward(req, resp);
    }
}
