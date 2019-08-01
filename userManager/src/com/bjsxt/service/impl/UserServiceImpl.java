package com.bjsxt.service.impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * @author Administrator
 * @date 2019/7/28 09:36:00
 * @description
 */
public class UserServiceImpl implements UserService {


    //声明Dao层对象
    UserDao userdao = new UserDaoImpl();
    //声明日志对象
    Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public int userRegService(User u) {
        logger.debug(u.getUname()+"发起注册请求");
        int index = userdao.userRegDao(u);
        if(index>0){
            logger.debug(u.getUname()+"注册成功");
        }else{
            logger.debug(u.getUname()+"注册失败");
        }
        return index;
    }

    //获取所有的用户信息
    @Override
    public List<User> userShowService() {
        List<User> users =   userdao.userShowDao();
        logger.debug("users:"+users);
        return users;
    }

    //修改用户密码
    @Override
    public int userChangePwdService(String newPwd, int uid) {
        logger.debug(uid+":发起密码修改请求");
        int index = userdao.userChangePwdDao(newPwd,uid);
        if(index>0){
            logger.debug(uid+":密码修改成功");
        }else{
            logger.debug(uid+":密码修改失败");
        }
        return index;

    }

    //用户登录
    @Override
    public User checkUserLoginService(String username, String password) {
        logger.debug(username+"发起登录请求");
        User user = userdao.checkUserLoginDao(username,password);
        if(user!=null){
            logger.debug("登录成功");
        }else{
            logger.debug("登录失败");
        }
        return user;
    }
}
