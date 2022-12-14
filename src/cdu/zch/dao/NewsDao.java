package cdu.zch.dao;

import cdu.zch.model.News;

import java.util.List;

public interface NewsDao {
    News get(int id);
    News findById(int id);
    List<News> findAll();//全查
    List<News> findByPage(int pageNum, int pageSize);//分页查询
    int count();//用于分页查询 得到有多少个对象

    int addMsg(News news);//添加
    int updateMsg(News news);//修改(传入对象
    int updateMsg(int id);//修改（传入id
    int deleteMsg(int id);//删除
}
