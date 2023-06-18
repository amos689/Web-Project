package com.iflytek.collegespace.service;

import com.iflytek.collegespace.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 新增用户
     * @param user 用户信息
     * @return 是否新增成功
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return 是否删除成功
     */
    int deleteUser(int id);

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 是否修改成功
     */
    int updateUser(User user);

    /**
     * 获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    User getUser(int id);

    User getUserByUsername(String username);

    /**
     * 获取所有用户信息
     * @return 所有用户信息
     */
    List<User> getAllUsers();
}

