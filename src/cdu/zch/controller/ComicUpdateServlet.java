package cdu.zch.controller;

import cdu.zch.model.Comic;
import cdu.zch.service.ComicService;
import cdu.zch.service.impl.ComicServiceImpl;
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

@WebServlet("/comic/update")
public class ComicUpdateServlet extends HttpServlet {

    ComicService comicService = new ComicServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");
        HttpSession session = req.getSession();
        session.setAttribute("id", id);
        Comic comic = comicService.getComicById(Integer.parseInt(id));
        System.out.println("这里调用了要修改的" + comic);
//        req.setAttribute("comic", comic);
//        req.getRequestDispatcher("update.do").forward(req, resp);
        Map<String, Object> map = new HashMap<>();
        map.put("comic", comic);
        String json = new Gson().toJson(map);
//        System.out.println("#####" + json);
        if(comic != null){
            out.write(json);
        }else{
            out.write("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("multipart/form-data; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Comic comic = null;
        //保存位置
        String path = "/photo";
        //保存位置的真实物理地址
        String savedDir = req.getServletContext().getRealPath(path);
        //创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //解析请求
            List<FileItem> items = upload.parseRequest(req);
            if (!items.isEmpty()) {
                comic = new Comic();
            }

            //创建迭代器准备处理表单数据
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
                //判断是表单域还是上传的文件
                if (item.isFormField()) {
                    //根据fieldName来判断是哪个表单控件
                    if (item.getFieldName().equals("id")) {
                        comic.setId(Integer.parseInt(new String(item.getString().getBytes("iso-8859-1"), "utf-8")));
                    }
                    if (item.getFieldName().equals("comicName")) {
                        comic.setComicName(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("nickname")) {
                        comic.setNickname(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("region")) {
                        comic.setRegion(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("label")) {
                        comic.setLabel(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("description")) {
                        comic.setDescription(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("remark")) {
                        comic.setRemark(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("year")) {
                        comic.setYear(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("updateTime")) {
                        comic.setUpdateTime(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                    if (item.getFieldName().equals("number")) {
                        comic.setNumber(Integer.parseInt(new String(item.getString().getBytes("iso-8859-1"), "utf-8")));
                    }
                    if (item.getFieldName().equals("popularity")) {
                        comic.setPopularity(Integer.parseInt(new String(item.getString().getBytes("iso-8859-1"), "utf-8")));
                    }
                    if (item.getFieldName().equals("url")) {
                        comic.setUrl(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                } else {
                    //获取上传文件文件名
                    String newName = UUID.randomUUID().toString();
                    String fileName = newName + item.getName();
                    System.out.println("文件名：" + fileName);
                    File file = new File(savedDir + "//" + fileName);
                    item.write(file);
                    comic.setCover(req.getContextPath() + path + "/" + fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("上传文件出错:" + e.getMessage());
        }
//        System.out.println("@@@@@" + comic);
        if (comicService.updateComic(comic) != 0) {
//            System.out.println("成功了");
            out.write("true");
        } else {
//            System.out.println("失败了");
            out.write("false");
        }
    }
}
