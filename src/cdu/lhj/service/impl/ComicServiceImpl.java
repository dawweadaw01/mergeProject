package cdu.lhj.service.impl;

import cdu.lhj.dao.ComicDao;
import cdu.lhj.dao.impl.ComicDaoImpl;
import cdu.lhj.model.Comic;
import cdu.lhj.service.ComicService;

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
