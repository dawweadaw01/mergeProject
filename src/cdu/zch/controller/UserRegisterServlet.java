package cdu.zch.controller;

import cdu.zch.model.User;
import cdu.zch.service.UserService;
import cdu.zch.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 上传头像
 * 注册
 * ps：传入的数据请一定使用二进制传入，例如：multipart/form-data
 * 请在from表单中设置
 */
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("multipart/form-data; charset=UTF-8");

        User user = null;
        //配置保存位置
        String path = "/photo";
        //获取上传文件的保存目录
        String savedDir = this.getServletContext().getRealPath(path);
        //创建一个通用的多部分解析器
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //解析请求，得到文件项集合
            List<FileItem> fileItems = upload.parseRequest(req);
            if (!fileItems.isEmpty()) {
                user = new User();
            }
            //创建迭代器,处理表单数据
            Iterator<FileItem> iterator = fileItems.iterator();
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
                //判断表单域，还是上传的文件
                if (item.isFormField()) {
                    if (item.getFieldName().equals("username")) {
                        user.setUserName(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if(item.getFieldName().equals("password")){
                        user.setPassword(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if(item.getFieldName().equals("email")){
                        user.setEmail(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if(item.getFieldName().equals("phone")){
                        user.setPhone(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    user.setCreateTime(new Date().getTime());
                } else {
                    //获取文件名
                    String fileName = new Date().getTime()+"_"+item.getName();
                    //保存文件
                    File file = new File(savedDir + "//" + fileName);
                    System.out.println(file);
                    item.write(file);
                    user.setAvatar(req.getContextPath() + path + "/" + fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("文件上传失败" + e.getMessage());
        }
        PrintWriter out = resp.getWriter();
//        userService.insert(user);
        if(userService.insert(user) == 1){
            out.write("true");
        }else{
            out.write("false");
        }
//        resp.sendRedirect("/user/user_login.do");
    }
}