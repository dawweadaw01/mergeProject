package cdu.zch.controller;

import cdu.zch.model.User;
import cdu.zch.service.UserService;
import cdu.zch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这只是个测试类，用于测试收藏和浏览历史的插入
 */
@WebServlet("/user/UpdateHistory")
public class UpdateBrowsingRecordsServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //全局获得用户
        User user = (User) request.getSession().getAttribute("user");
        String comicId = request.getParameter("id");
        //此时的id为动漫id
        int row =userService.updateCollection(user, comicId);
        System.out.println("user"+user);
        System.out.println("comicId"+comicId);
        String s = request.getParameter("id");
        System.out.println(row);
    }
}
