<%--
  Created by IntelliJ IDEA.
  User: guojianhua
  Date: 2019/7/12
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/predicted">
    商家编号<input type="text" name="shopid" id="shopid">
    <button type="submit">预测</button>
</form>
<table>

<tr>
    <td>类别</td>
    <td>第一天</td>
    <td>第二天</td>
    <td>第三天</td>
</tr>

        <tr>
            <td>预计金额</td>
            <c:forEach  items="${sum}" var="sum_day">
            <td>${sum_day}</td>
            </c:forEach>
        </tr>
    <tr>
        <td>预计订单数</td>
        <c:forEach  items="${count}" var="count_day">
            <td>${count_day}</td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
