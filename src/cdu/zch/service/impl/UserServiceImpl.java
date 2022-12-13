package cdu.zch.service.impl;
import cdu.zch.dao.UserDao;
import cdu.zch.dao.impl.UserDaoImpl;
import cdu.zch.model.Admin;
import cdu.zch.model.User;
import cdu.zch.service.UserService;

import java.util.List;

/**
 * insert(User user);用于注册用户
 * login(String name,String password);用于登录
 * updateHistory(User user, String comicId);用于更新浏览历史
 * updateCollection(User user, String comicId);用于更新收藏
 * loginAdmin(String adminName,String password);用于管理员登录
 * selectByUserId(int id);用于根据用户id查询用户
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String name, String password) {
        return userDao.login(name,password);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public Admin loginAdmin(String adminName, String password) {
        return userDao.loginAdmin(adminName,password);
    }

    @Override
    public int updateHistory(User user, String comicId) {
        return userDao.updateHistory(user,comicId);
    }

    @Override
    public int updateCollection(User user, String comicId) {
        return userDao.updateCollection(user,comicId);
    }

    @Override
    public User selectByUserId(int id) {
        return userDao.selectByUserId(id);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> selectByName(String adminName) {
        return userDao.selectByName(adminName);
    }


    @Override
    public int countUser() {
        return userDao.countUser();
    }

    @Override
    public List<User> selectAllUser(int pageNum, int pageSize) {
        return userDao.selectAllUser(pageNum,pageSize);
    }

    @Override
    public int countAdmin() {
        return userDao.countAdmin();
    }

    @Override
    public List<Admin> selectAllAdmin(int pageNum, int pageSize) {
        return userDao.selectAllAdmin(pageNum, pageSize);
    }
}

