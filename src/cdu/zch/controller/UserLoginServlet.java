package cdu.zch.controller;

import cdu.zch.model.User;
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
 * 登录类，用于登录，并将得到的user存入到session中
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String inputCode = req.getParameter("inputCode");
        HttpSession session = req.getSession();
//        String validCode = (String) session.getAttribute("validCode");
//        System.out.println(validCode);
//        System.out.println(inputCode);
//        if (validCode == null || validCode.equals("") || !validCode.equalsIgnoreCase(inputCode)) {
//            //验证码错误
//            req.setAttribute("msg", "验证码错误");
//            resp.sendRedirect("user/login.do");
//            return;
//        }
        session.removeAttribute("validCode");//验证完验证码之后删除验证码
        User user = userService.login(username, password);
        PrintWriter out = resp.getWriter();
        if (user != null) {
            session.setAttribute("user", user);
            out.write("true");
//            resp.sendRedirect(req.getContextPath() + "/user/test2.do");
            /*
              这个位置的重定向请根据需求来写，建议所有的重定向使用req.getContextPath() + "/*。。。"这种方式
             */
        }else {
            out.write("false");
//            resp.sendRedirect("user/login.do");//与上文同理
        }

    }

}