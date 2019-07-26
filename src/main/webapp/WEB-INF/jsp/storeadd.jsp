<%--
  Created by IntelliJ IDEA.
  User: guojianhua
  Date: 2019/7/10
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/store/added" method="post">

    商家姓名：<br>
    <input type="text" name="name" ><br>
    联系方式：<br>
    <input type="text" name="phone" ><br>
    地址：<br>
    <input type="text" name="address" ><br>
    <button type="submit" >确认添加</button>
</form>
</body>
</html>
