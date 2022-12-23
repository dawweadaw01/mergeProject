package cdu.zch.filter;

import cdu.zch.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截的/user/*的请求
 * 所以用户页面的jsp请放在/user/下
 * 重定向请根据需求重定向
 * 请一定更改重定向的路径
 */
@WebFilter(filterName = "UserFilter", urlPatterns = "/user/*")
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher(req.getContextPath() + "user_login.do").forward(req, resp);
        }
    }
}