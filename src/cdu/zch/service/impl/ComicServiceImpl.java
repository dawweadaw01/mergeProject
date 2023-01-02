package cdu.zch.service.impl;

import cdu.zch.dao.ComicDao;
import cdu.zch.dao.impl.ComicDaoImpl;
import cdu.zch.model.Comic;
import cdu.zch.service.ComicService;

import java.util.List;

public class ComicServiceImpl implements ComicService {
    ComicDao comicDao=new ComicDaoImpl();

    @Override
    public int addComic(Comic comic) {
        return comicDao.addComic(comic);
    }

    @Override
    public List<Comic> getComic(String region) {
        return comicDao.getComic(region);
    }

    @Override
    public int count(int region) {
        return comicDao.count(region);
    }

    @Override
    public List<Comic> getIndexComic() {
        return comicDao.getIndexComic();
    }

    @Override
    public int delComic(int id) {
        return comicDao.deleteComic(id);
    }

    @Override
    public Comic getComicById(int id) {
        return comicDao.getComicById(id);
    }

    @Override
    public int updateComic(Comic comic) {
        return comicDao.updateComic(comic);
    }

    @Override
    public List<Comic> searchComic(int first,int last,String value) {
        return comicDao.searchComic((first-1)*last,last,value);
    }

    @Override
    public int searchCount(String comicName) {
        return comicDao.searchCount(comicName);
    }

    @Override
    public int count() {
        return comicDao.count();
    }

    @Override
    public List<Comic> selectAllComic(int pageNum, int pageSize) {
        return comicDao.selectAllComic(pageNum, pageSize);
    }


}
