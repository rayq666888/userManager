package com.bjsxt.util;

import java.sql.*;

/**
 * @author Administrator
 * @date 2019/7/28 10:03:32
 * @description
 */
public class JDBCUtil {
    public static Connection getConnection(){
        Connection conn = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjxst_usersystem","root","root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn ;
    }

    public static void closeConnection(Connection conn, Statement statement, ResultSet resultSet){

        try {
            if(resultSet!=null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
