<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理员界面</title>
</head>
<body>
<div id="menu" style="background-color:#FFD700;height:200px;width:100px;float:left;">
    <input type="button" value="商家管理" onclick="location.href='/store/show'">
    <input type="button" value="添加商家" onclick="location.href='/store/add'">
    <input type="button" value="用户管理" onclick="location.href='/user/show'">
    <input type="button" value="相关统计" onclick="location.href='/order/chart'">
    <input type="button" value="未来预计" onclick="location.href='/predicted'">
</div>

</body>
</html>