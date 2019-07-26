<%--
  Created by IntelliJ IDEA.
  User: guojianhua
  Date: 2019/7/10
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>某商家详情</title>
</head>
<body>

<form action="/store/edited" method="post">

    商家姓名：<br>
    <input type="text" name="name" value="${store.name}"><br>
    联系方式：<br>
    <input type="text" name="phone" value="${store.phone}"><br>
    地址：<br>
    <input type="text" name="address" value="${store.address}"><br>
    <input type="hidden" name="id" value="${store.id}" >
    <button type="submit" >确认修改</button>
</form>
</body>
</html>
