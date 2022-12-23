package cdu.zch.filter;

import cdu.zch.model.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截的/admin/*的请求，判断是否为管理员
 * 所以管理页面的jsp请放在/admin/下
 * 请一定更改重定向的路径
 */
@WebFilter(filterName = "adminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher(req.getContextPath() + "admin_login.do").forward(req,resp);
        }
    }
}