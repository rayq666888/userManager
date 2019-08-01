package com.bjsxt.servlet;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class UserServlet extends HttpServlet {
    String encoding = "utf-8";
    //声明service层对象
    UserService userService = new UserServiceImpl();
    //声明日志对象
    Logger logger = Logger.getLogger(UserServlet.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding(encoding);
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取操作符
        String oper = request.getParameter("oper");
        if ("login".equals(oper)) {
            //调用登录功能
            checkUserLogin(request,response);
        } else if ("out".equals(oper)) {
            userOut(request,response);
            //调用退出功能
        } else if ("pwd".equals(oper)) {
            //调用修改密码功能
            userChangePwd(request,response);
        } else if ("show".equals(oper)) {
            //调用显示所有用户的功能
            userShow(request,response);
        } else if ("reg".equals(oper)) {
            //调用注册功能
            userReg(request,response);
        }else{
            logger.debug("没有找到对应的操作符"+oper);
        }
    }

    //注册用户
    private void userReg(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取请求信息
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        int age = !("".equals(request.getParameter("age")))?Integer.parseInt(request.getParameter("age")):0;
        String birth = request.getParameter("birth");
        String[] bs = null ;
        if(birth!="") {
            bs = birth.split("/");
            birth = bs[2]+ "-"+bs[0] + "-"+ bs[1];
        }

        User u = new User(0,uname,pwd,sex,age,birth);
        //处理请求信息
        int index = userService.userRegService(u);
        //响应处理结果
        if(index>0){
           //获取session
            HttpSession hs = request.getSession() ;
            hs.setAttribute("reg","true");
            //重定向
            response.sendRedirect("/userManager/login.jsp");
        }

    }

    /**
     * 显示所有的用户信息
     * @param request
     * @param response
     */
    private void userShow(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //处理请求
            //调用service
            List<User> users = userService.userShowService();
            request.setAttribute("users",users);
            request.getRequestDispatcher("/user/showUser.jsp").forward(request,response);

    }


    private void userChangePwd(HttpServletRequest request,HttpServletResponse response) throws IOException {
         //获取数据
            String newPwd = request.getParameter("newPwd");
            //从session中获取用户信息
            User u = (User)request.getSession().getAttribute("user");
            int uid = u.getUid() ;
        //处理请求
           //调用service处理
            int index = userService.userChangePwdService(newPwd,uid);
            if(index>0){
                //获取session对象
                HttpSession hs = request.getSession();
                hs.setAttribute("pwd",true);
                //重定向到登录页面
                response.sendRedirect("/userManager/login.jsp");
            }
    }

    /**
     * 用户退出
     */
    private void userOut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取用户的sessioin
        HttpSession session = request.getSession() ;
        //强制销毁session
        session.invalidate();
        //重定向到登录页面
        response.sendRedirect("/userManager/login.jsp");
    }


    /**
     * 处理登录
     * @param request  请求对象
     * @param response  响应对象
     */
    private void checkUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //获取请求信息
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        //处理登录
        User user = userService.checkUserLoginService(uname,pwd);
        if(user!=null){
            HttpSession hs = request.getSession() ;
            //将用户数据存储到session中
            hs.setAttribute("user",user);
            //重定向
            System.out.println("路径:"+this.getServletContext().getContextPath());
            response.sendRedirect("/userManager/main/main.jsp");
            return ;
        }else{
            //添加标识符到request中
            request.setAttribute("flag",0);

            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return ;
        }
    }

}
