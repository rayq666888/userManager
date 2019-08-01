package com.bjsxt.dao.test;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.pojo.User;
import org.junit.Test;

/**
 * @author Administrator
 * @date 2019/7/28 09:59:48
 * @description
 */
public class UserDaoTest {
    UserDao  dao = new UserDaoImpl();
    @Test
    public void checkUserLoginDaoTest(){
        User user = dao.checkUserLoginDao("张三","123");
        System.out.println(user);
    }
}
