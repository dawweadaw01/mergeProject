package cdu.zch.service.impl;

import cdu.zch.dao.NewsDao;
import cdu.zch.dao.impl.NewsDaoImpl;
import cdu.zch.model.News;
import cdu.zch.service.NewsService;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    NewsDao newsDao = new NewsDaoImpl();

    @Override
    public List<News> findByPage(int pageNum, int pageSize) {
        return newsDao.findByPage(pageNum, pageSize);
    }

    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    @Override
    public int count() {
        return newsDao.count();
    }

    @Override
    public News get(String sid) {
        if(sid == null || sid.equals("")){
            return null;
        }
        return get(Integer.parseInt(sid));
    }

    @Override
    public News get(int id) {
        return newsDao.findById(id);
    }

    @Override
    public Boolean addNews(News news) {
        return newsDao.addMsg(news)==1;
    }

    @Override
    public Boolean updateNews(News news) {
        return newsDao.updateMsg(news)==1;
    }

    @Override
    public Boolean updateNews(int id) {
        return newsDao.updateMsg(id)==1;
    }

    @Override
    public Boolean del(int id) {
        System.out.println("运行到service层");
        return newsDao.deleteMsg(id) == 1;
    }

    @Override
    public Boolean deleteNews(String sid) {
        if(sid == null || sid.equals("")){
            return false;
        }
        return newsDao.deleteMsg(Integer.parseInt(sid)) == 1 ? true : false;
    }
}
