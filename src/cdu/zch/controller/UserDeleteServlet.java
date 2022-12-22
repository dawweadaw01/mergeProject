package cdu.zch.controller;

import cdu.zch.service.UserService;
import cdu.zch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String sid = req.getParameter("id");

//        System.out.println("sid:" + sid);
//        if(sid==null || "".equals(sid)){
//            resp.sendRedirect("list");
//            return;
//        }

        //删除
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        if (userService.delete(Integer.parseInt(sid)) == 1){
            out.write("true");
        }else{
            out.write("false");
        }
    }
}
