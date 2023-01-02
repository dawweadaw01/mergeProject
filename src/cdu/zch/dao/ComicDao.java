package cdu.zch.dao;

import cdu.zch.model.Comic;

import java.util.List;

public interface ComicDao {
    //添加动漫
    int addComic(Comic comic);
    //根据地区查找
    List<Comic> getComic(String region);
    //计算该类动漫个数
    int count(int region);
    //获取轮播图动漫（热度前五）
    List<Comic> getIndexComic();
    //根据id查找
    Comic getComicById(int id);
    //修改动漫
    int updateComic(Comic comic);
    //删除动漫
    int deleteComic(int id);
    //搜索动漫
    List<Comic> searchComic(int first,int last,String comicName);
    //搜索动漫的总量
    int searchCount(String comicName);

    // 下面是分页
    int count();
    List<Comic> selectAllComic(int pageNum, int pageSize);

}
