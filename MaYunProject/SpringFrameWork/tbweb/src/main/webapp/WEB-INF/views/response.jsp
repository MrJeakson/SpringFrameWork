<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/6
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <title>Title</title>
    </head>
<body>
<form name="myDemo" action="/user/show.do" method="post">
<c:forEach var="user" items="${userList}" >

    <h1>用户信息</h1>
    <table>

        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>
        </tr>
    </table>
</c:forEach>
</form>

</body>
</html>
