package cdu.zch.service;

import cdu.zch.model.News;

import java.util.List;

public interface NewsService {

    List<News> findByPage(int pageNum, int pageSize);
    List<News> findAll();

    int count();

    News get(String sid);
    News get(int id);
    Boolean addNews(News news);
    Boolean updateNews(News news);
    Boolean updateNews(int id);
    Boolean del(int id);
    Boolean deleteNews(String sid);
}
