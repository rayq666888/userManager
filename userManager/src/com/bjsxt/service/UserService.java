package com.bjsxt.service;

import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.User;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/7/28 09:55:17
 * @description
 */
public interface UserService {

    /**
     * 用户注册
     * @param u
     * @return
     */
    int userRegService(User u);

    /**
     * 获取所有的用户信息
     * @return 所有用户信息
     */
    List<User> userShowService();

    /**
     * 修改用户密码
     * @param newPwd  新密码
     * @param uid  用户id
     * @return  受影响行数
     */
     int userChangePwdService(String newPwd,int uid);

    /**
     * 检验用户名和密码
     * @param username 用户名
     * @param password 密码
     * @return  查询到的用户信息
     */
     User checkUserLoginService(String username,String password);
}
