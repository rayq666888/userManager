package com.bjsxt.service.test;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author Administrator
 * @date 2019/7/28 10:45:58
 * @description
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void checkUserLoginServiceTest(){
        User user = userService.checkUserLoginService("张三","123");
        System.out.println(user);
    }
}
