<%@ page import="com.bjsxt.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <base href=<%=basePath %>/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">管理信息</a></li>
        <li><a href="#">查看用户信息</a></li>
    </ul>
</div>

<div class="rightinfo">


    <table class="tablelist">
        <thead>
        <tr>
            <th>用户ID<i class="sort"><img src="images/px.gif"/></i></th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>出生年月</th>
        </tr>
        </thead>
        <tbody>

                        <%
                            List<User> users = (List<User>) (request.getAttribute("users"));
                            for(User u: users){
                        %>
                        <tr>
                            <td><%=u.getUid() %></td>
                            <td><%=u.getUname() %></td>
                            <td><%=u.getPwd() %></td>
                            <%
                                if("1".equals(u.getSex())){
                            %>
                            <td>男</td>
                            <%
                                }else{
                            %>
                            <td>女</td>
                            <%
                                }
                            %>
                            <td><%=u.getAge() %></td>
                            <td><%=u.getBirth() %></td>
                        </tr>
                        <%
                            }
                        %>
<%--        <c:forEach items="${users}" var="user">--%>
<%--            <tr>--%>
<%--                <td>${user.uid}</td>--%>
<%--                <td>${user.uname}</td>--%>
<%--                <td>${user.pwd}</td>--%>
<%--                <td>${user.sex=='1'?'男':'女'}</td>--%>
<%--                <td>${user.age}</td>--%>
<%--                <td>${user.birth}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>

        </tbody>
    </table>

    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png"/></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>

    </div>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
