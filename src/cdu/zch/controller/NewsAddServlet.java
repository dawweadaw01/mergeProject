package cdu.zch.controller;

import cdu.zch.model.News;
import cdu.zch.service.NewsService;
import cdu.zch.service.impl.NewsServiceImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet("/news/add")
public class NewsAddServlet extends HttpServlet {
    NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.do").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = null;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("multipart/form-data; charset=UTF-8");

        //配置图片保存位置
        String path = "/newsCover";
        //获取保存位置对应得到真实位置
        String savedDir = req.getServletContext().getRealPath(path);
        //创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //解析请求
            List<FileItem> items = upload.parseRequest(req);
            if (!items.isEmpty()) {
                news = new News();
            }

            //创建迭代器，准备处理表单内容
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
                if (item.isFormField()) {
                    //判断表单域，还是上传的文件
                    if (item.getFieldName().equals("title")) {
                        news.setTitle(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("author")) {
                        news.setAuthor(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("source")) {
                        news.setSource(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("textContent")) {
                        news.setTextContent(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String f = sdf.format(date);
                    news.setCreatTime(f);
                } else {
//                    System.out.println(item.getName());
                    String newName = UUID.randomUUID().toString();
                    String filename = newName + item.getName();
                    System.out.println("文件名2：" + filename);
                    File file = new File(savedDir + "//" + filename);
                    item.write(file);
                    news.setImgCover(req.getContextPath() + path + "/" + filename);
                }
            }
        } catch (Exception e) {
            System.out.println("文件上传错误：" + e.getMessage());
        }
        System.out.println(news);
        PrintWriter out = resp.getWriter();
        if (newsService.addNews(news)) {
//            resp.sendRedirect("latestComicInfo");//跳转
            out.write("true");

        } else {
//            System.out.println("fail to upload file");
//            resp.sendRedirect("addNewsServlet");
            out.write("false");
        }
    }
}