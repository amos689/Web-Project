package com.iflytek.collegespace.dao.impl;

import com.iflytek.collegespace.dao.UserDao;
import com.iflytek.collegespace.entity.User;
import com.iflytek.collegespace.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());

    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO `user`(username,`password`,nickname,email,avatar)" +
                "VALUE(?,?,?,?,?)";
        try {
            return runner.update(sql, user.getUsername(), user.getPassword(),user.getNickname(),
                    user.getEmail(), user.getAvatar());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        try {
            return runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateUser(User user) {
        String sql = "UPDATE user SET username=?,password=?,nickname=?,email=?,avatar=?" +
                " WHERE id=?";
        try {
            return runner.update(sql, user.getUsername(),user.getPassword(),
                    user.getNickname(),user.getEmail(),user.getAvatar(), user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUser(int id) {
        String sql = "SELECT * FROM user WHERE id=?";
        try {
            return runner.query(sql, new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        try {
            return runner.query(sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username=?";
        try {
            return runner.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
