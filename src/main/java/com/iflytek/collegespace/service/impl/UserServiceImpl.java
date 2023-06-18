package com.iflytek.collegespace.service.impl;

import com.iflytek.collegespace.dao.UserDao;
import com.iflytek.collegespace.dao.impl.UserDaoImpl;
import com.iflytek.collegespace.entity.User;
import com.iflytek.collegespace.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public int addUser(User user) {
        return dao.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return dao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return dao.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return dao.getUser(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}
