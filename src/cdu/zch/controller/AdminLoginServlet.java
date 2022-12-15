package cdu.zch.controller;

import cdu.zch.model.Admin;
import cdu.zch.service.UserService;
import cdu.zch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 管理员登录类，用于登录，并将得到的user存入到session中
 * 与登录类同理
 */
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String adminName = req.getParameter("adminName");
        String password = req.getParameter("password");
        String validCode = req.getParameter("validCode");
        HttpSession session = req.getSession();
        String inputCode = (String) session.getAttribute("validCode");
        if (validCode == null || validCode.equals("") || !validCode.equalsIgnoreCase(inputCode)) {
            //验证码错误
            req.setAttribute("msg", "验证码错误");
            resp.sendRedirect("admin/admin_login.do");
            return;
        }
        session.removeAttribute("validCode");
        Admin admin = userService.loginAdmin(adminName, password);
        PrintWriter out = resp.getWriter();
        if (admin != null) {
            session.setAttribute("admin", admin);
            out.print("true");
//            req.getRequestDispatcher("manage/manage.do").forward(req, resp);
        }else {
            out.print("false");
//            resp.sendRedirect("admin/admin_login.do");
        }
    }
}
