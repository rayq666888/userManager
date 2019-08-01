package com.bjsxt.dao.impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.User;
import com.bjsxt.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/7/28 09:54:16
 * @description
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int userRegDao(User u) {
        //声明jdbc对象
        Connection conn = null ;
        PreparedStatement ps = null ;
        //声明变量
        int index = -1 ;
        try{
            //加载驱动
            //获取连接
            conn = JDBCUtil.getConnection() ;
            //创建SQL命令
            String sql = "insert into t_user values(default ,?,?,?,?,?)";
            //创建SQL命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,u.getUname());
            ps.setString(2,u.getPwd());
            ps.setString(3,u.getSex());
            ps.setInt(4,u.getAge());
            ps.setString(5,u.getBirth());
            //执行
             index = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtil.closeConnection(conn,ps,null);
        }
        //返回结果
        return index;
    }

    //获取所有的用户信息
    @Override
    public List<User> userShowDao() {
        //声明jdbc对象
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        //创建变量
        List<User> users = new ArrayList<User> ();
        try{
            //加载驱动
            //获取连接
            conn = JDBCUtil.getConnection() ;
            //创建SQL命令
            String sql = "select * from t_user ";
            //创建SQL命令对象
            ps = conn.prepareStatement(sql);
            //执行
            rs = ps.executeQuery();
            //遍历结果
            while (rs.next()){
                int uid = rs.getInt("uid");
                String uname = rs.getString("uname");
                String pwd = rs.getString("pwd");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                String birth = rs.getString("birth");
                User user = new User(uid,uname,pwd,sex,age,birth);
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtil.closeConnection(conn,ps,rs);
        }
        //返回结果
        return users;
    }

    //根据用户id修改用户密码
    @Override
    public int userChangePwdDao(String newPwd, int uid) {
        //声明jdbc对象
        Connection conn = null ;
        PreparedStatement ps = null ;
        //创建变量
        int index = -1 ;
        try{
            //加载驱动
            //获取连接
            conn = JDBCUtil.getConnection() ;
            //创建SQL命令
            String sql = "update t_user set pwd = ? where uid = ?";
            //创建SQL命令对象
            ps = conn.prepareStatement(sql);
            //给占位符复制
            ps.setString(1,newPwd);
            ps.setInt(2,uid);
            //执行
            index = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtil.closeConnection(conn,ps,null);
        }
        //返回结果
        return index;
    }

    @Override
    public User checkUserLoginDao(String username, String password) {
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        User user = null ;
        String sql = "select * from t_user where uname= ? and pwd = ?" ;
        conn = JDBCUtil.getConnection() ;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery() ;
            while(rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getString("birth"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConnection(conn,ps,rs);
        }
        return user;
    }
}
