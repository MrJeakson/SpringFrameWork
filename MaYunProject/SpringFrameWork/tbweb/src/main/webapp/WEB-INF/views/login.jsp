<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/6
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/doResponse.do" method="post">

    <div>用户登录</div>
    用户名：<input type="text" name="name" placeholder="手机或邮箱"/>
    密码：<input type="text" name="password" placeholder="请输入密码"/>
    <button type="submit" name="submit">登录</button>



</form>

</body>
</html>
