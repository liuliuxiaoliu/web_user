package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    //增
    int save(User user,int Id);
    //删
    int delete(int Id);
    //改
    int update(User user,int Id);
    //查
    //单个
    User selectById(int Id);
    //全部
    List<User> selectAll();
}
