<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/7
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>PictureUpload</title>
</head>
<body>
    <h1>文件上传</h1>
    <h1>${msg}</h1>
<form action="/upload/doUpload.do" method="post" enctype="multipart/form-data">

    <input type="file" name="upfile"/>
    <br/>
    <input type="submit" value="upload"/>

</form>
</body>
</html>
