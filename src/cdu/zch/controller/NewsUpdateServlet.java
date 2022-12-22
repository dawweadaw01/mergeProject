package cdu.zch.controller;

import cdu.zch.model.News;
import cdu.zch.service.NewsService;
import cdu.zch.service.impl.NewsServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/news/update")
public class NewsUpdateServlet extends HttpServlet {

    NewsService newsService = new NewsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String sid = req.getParameter("id");
        News news = newsService.get(sid);
        HttpSession session = req.getSession();
        session.setAttribute("sid",sid);
//        System.out.println("sid="+sid);

//        req.setAttribute("news",news);
//
//        req.getRequestDispatcher("mod.do").forward(req,resp);
        Map<String, Object> map = new HashMap<>();
        map.put("news", news);
        String json = new Gson().toJson(map);
//        System.out.println("#####" + json);
        if(news != null){
            out.write(json);
        }else{
            out.write("false");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        News news =null;
        HttpSession session = req.getSession();
        String path = "/newsCover";

        String savedDir = req.getServletContext().getRealPath(path);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try{
            //解析请求
            List<FileItem> items = upload.parseRequest(req);
            if(!items.isEmpty()){
                news = new News();
            }
            //创建迭代器，准备处理表单内容
            Iterator<FileItem> iterator=items.iterator();
            while(iterator.hasNext()){
                FileItem item = iterator.next();
                if (item.isFormField()){
                    //判断表单域，还是上传的文件
                    if (item.getFieldName().equals("id")) {
                        news.setId(Integer.parseInt(new String(item.getString().getBytes("iso-8859-1"), "utf-8")));
                    }
                    if (item.getFieldName().equals("title")){
                        news.setTitle(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                    if(item.getFieldName().equals("author")){
                        news.setAuthor(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                    if(item.getFieldName().equals("source")){
                        news.setSource(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                    if(item.getFieldName().equals("textContent")){
                        news.setTextContent(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                }
                else {
//                    System.out.println(item.getName());
                    String newName= UUID.randomUUID().toString();
                    String filename=newName+item.getName();
                    System.out.println("文件4：" + filename);
                    File file=new File(savedDir+"//"+filename);
                    item.write(file);
                    news.setImgCover(req.getContextPath()+path+"/"+filename);
                }
            }
        }catch (Exception e){
            System.out.println("文件修改失败："+e.getMessage());
        }
//        String sid = (String) session.getAttribute("sid");
//        news.setId(Integer.parseInt(sid));

        if(newsService.updateNews(news)){
            //完成修改
            out.write("true");
        }else {
            out.write("false");
        }

    }
}
