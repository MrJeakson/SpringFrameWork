<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/8
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">

    function clickAjax() {

        var xmlHttp = new XMLHttpRequest();

        xmlHttp.onreadystatechange=function()
        {
            if (xmlHttp.readyState==4 && xmlHttp.status==200)
            {
                document.getElementById("myDiv").innerHTML=xmlHttp.responseText;
                alert(xmlHttp.responseText);
            }
        }
        xmlHttp.open("GET","/user/doResponse.do?pageCurrent=10&pageSize=10",true);
        xmlHttp.send();

    }

</script>
<body>
        <div><h1>请输入用户名</h1></div>
        <input type="text" placeholder="用户名"/>
        <input type="submit" onclick="clickAjax()"/>
        <div id="myDiv">I'm new One</div>
</body>
</html>
