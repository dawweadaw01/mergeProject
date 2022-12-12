package cdu.zch.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jsp的解析
 * 1.获取请求路径
 * 2.截取请求路径
 * 3.转发到指定路径
 */
@WebServlet("*.do")
public class JspServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String root = req.getContextPath();
        path = path.substring(root.length(), path.length() - 3);
        path = "/WEB-INF/jsp" + path + ".jsp";

        req.getRequestDispatcher(path).forward(req, resp);
    }
}