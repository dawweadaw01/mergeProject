package cdu.zch.dao;
import cdu.zch.model.Admin;
import cdu.zch.model.User;

import java.util.List;

/**
 * insert(User user);用于注册用户
 * login(String name,String password);用于登录
 * updateHistory(User user, String comicId);用于更新浏览历史
 * updateCollection(User user, String comicId);用于更新收藏
 * loginAdmin(String adminName,String password);用于管理员登录
 * selectByUserId(int id);用于根据用户id查询用户
 */
public interface UserDao {
    int insert(User user);
    User login(String name,String password);
    int updateHistory(User user, String comicId);
    User selectByUserId(int id);

    int updateCollection(User user, String comicId);

    Admin loginAdmin(String adminName,String password);

    int delete(int id);

    int update(User user);

    //根据用户名模糊查询
    List<User> selectByName(String adminName);

    // 下面两个是分页渲染数据
    int countUser();

    List<User> selectAllUser(int pageNum, int pageSize);

    int countAdmin();

    List<Admin> selectAllAdmin(int pageNum, int pageSize);

}
