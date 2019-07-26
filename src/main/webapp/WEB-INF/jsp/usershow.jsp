<%--
  Created by IntelliJ IDEA.
  User: guojianhua
  Date: 2019/7/13
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>商家列表</title>
</head>
<script>

</script>
<body>
<div>
    <table border="1">
        <tr>
            <td>用户名字</td>
            <td>用户号码</td>
            <td>用户生日</td>
            <td>操作</td>
        </tr>
        <c:forEach  items="${users.list}" var="user">


            <tr>
                <td>${user.name}</td>
                <td>${user.phone}</td>
                <td>${user.birth}</td>
                <td>
                    <a href="/user/edit/id=${user.id}">编辑</a>
                    <a href="/user/delete/id=${user.id}">删除</a>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
<div>
    <div>
        当前第${users.pageNum}页.总共${users.pages}页.一共${users.total}条记录
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/user/show?pn=1" >首页</a>
        <c:if test="${users.hasPreviousPage}">
            <a href="${pageContext.request.contextPath}/user/show?pn=${users.pageNum-1}" >
                <span>«</span>
            </a>
        </c:if>


        <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
        <c:forEach items="${users.navigatepageNums}" var="page_num">
            <c:if test="${page_num == users.pageNum}">
                <a href="#">${page_num}</a>
            </c:if>
            <c:if test="${page_num != users.pageNum}">
                <a href="${pageContext.request.contextPath}/user/show?pn=${page_num}">${page_num}</a>
            </c:if>
        </c:forEach>

        <!--下一页-->

        <c:if test="${users.hasNextPage}">
            <a href="${pageContext.request.contextPath}/user/show?pn=${users.pageNum+1}">
                <span aria-hidden="true">»</span>
            </a>
        </c:if>

        <a href="${pageContext.request.contextPath}/user/show?pn=${users.pages}">尾页</a>
    </div>

</div>
</body>
</html>
