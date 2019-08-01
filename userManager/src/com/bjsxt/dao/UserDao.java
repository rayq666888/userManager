package com.bjsxt.dao;

import com.bjsxt.pojo.User;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/7/28 09:52:02
 * @description
 */
public interface UserDao {

    /**
     * 用户注册
     * @param u
     * @return
     */
    int userRegDao(User u);

    /**
     * 获取所有的用户信息
     * @return  所有的用户信息
     */
    List<User> userShowDao();

    /**
     * 根据用户id修改用户密码
     * @param newPwd
     * @param uid
     * @return
     */
    int userChangePwdDao(String newPwd,int uid);

    /**
     * 根据用户名和密码查询用户信息
     * @param username  用户名
     * @param password  密码
     * @return  查询到的用户信息
     */
    User checkUserLoginDao(String username, String password);
}
