package cdu.zch.service;

import cdu.zch.model.Comic;

import java.util.List;

public interface ComicService {
    //添加动漫
    int addComic(Comic comic);
    //根据地区获取动漫
    List<Comic> getComic(String region);
    //根据地区获取动漫总数
    int count(int region);
    //根据热度获取动漫
    List<Comic> getIndexComic();
    //根据id删除动漫
    int delComic(int id);
    //根据id查找动漫
    Comic getComicById(int id);
    //修改动漫
    int updateComic(Comic comic);
    //搜索动漫
    List<Comic> searchComic(int first,int last,String value);
    //搜索动漫个数
    int searchCount(String comicName);

    // 分页
    int count();
    List<Comic> selectAllComic(int pageNum, int pageSize);

}
