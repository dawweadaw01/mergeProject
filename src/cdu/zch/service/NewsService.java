package cdu.zch.service;

import cdu.zch.model.News;

import java.util.List;

public interface NewsService {

    List<News> findByPage(int pageNum, int pageSize);
    List<News> findAll();

    int count();

    News get(String sid);
    News get(int id);
    boolean addNews(News news);
    boolean updateNews(News news);
    boolean updateNews(int id);
    boolean del(int id);
    boolean deleteNews(String sid);
}
