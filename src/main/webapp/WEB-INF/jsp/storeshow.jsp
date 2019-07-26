<%--
  Created by IntelliJ IDEA.
  User: guojianhua
  Date: 2019/7/9
  Time: 20:49
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
            <td>商店名字</td>
            <td>商店号码</td>
            <td>商店地址</td>
            <td>操作</td>
        </tr>
<c:forEach  items="${storelist.list}" var="store">


    <tr>
        <td>${store.name}</td>
        <td>${store.phone}</td>
        <td>${store.address}</td>
        <td>
           <a href="/store/edit/id=${store.id}">编辑</a>
            <a href="/store/delete/id=${store.id}">删除</a>
        </td>
    </tr>

</c:forEach>
    </table>
</div>
<div>
    <div>
        当前第${storelist.pageNum}页.总共${storelist.pages}页.一共${storelist.total}条记录
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/store/show?pn=1" >首页</a>
        <c:if test="${storelist.hasPreviousPage}">
                <a href="${pageContext.request.contextPath}/store/show?pn=${storelist.pageNum-1}" >
                    <span>«</span>
                </a>
        </c:if>


        <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
        <c:forEach items="${storelist.navigatepageNums}" var="page_num">
            <c:if test="${page_num == storelist.pageNum}">
                <a href="#">${page_num}</a>
            </c:if>
            <c:if test="${page_num != storelist.pageNum}">
                <a href="${pageContext.request.contextPath}/store/show?pn=${page_num}">${page_num}</a>
            </c:if>
        </c:forEach>

        <!--下一页-->

        <c:if test="${storelist.hasNextPage}">
            <a href="${pageContext.request.contextPath}/store/show?pn=${storelist.pageNum+1}">
                <span aria-hidden="true">»</span>
            </a>
        </c:if>

       <a href="${pageContext.request.contextPath}/store/show?pn=${storelist.pages}">尾页</a>
    </div>

</div>
</body>
</html>
