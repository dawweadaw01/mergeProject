package cdu.zch.service;

import cdu.zch.model.Admin;
import cdu.zch.model.User;

import java.util.List;

public interface UserService {
    User login(String name,String password);
    int insert(User user);
    Admin loginAdmin(String adminName,String password);
    int updateHistory(User user, String comicId);

    int updateCollection(User user, String comicId);

    User selectByUserId(int id);

    int delete(int id);

    int update(User user);

    List<User> selectByName(String adminName);

    int countUser();

    List<User> selectAllUser(int pageNum, int pageSize);

    int countAdmin();

    List<Admin> selectAllAdmin(int pageNum, int pageSize);

}
