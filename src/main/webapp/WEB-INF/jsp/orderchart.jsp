<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: guojianhua
  Date: 2019/7/11
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
    <%--springboot默认资源在在static里--%>
    <script type="text/javascript" src="../../static/echarts.min.js"></script>
    <script type="text/javascript" src="../../static/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        function alertValue()
        {
            alert(document.getElementById("year_month").value)
        }
    </script>
    </head>
<body>
<div>
<form action ="/order/chart">
<input style="margin:auto;" type="text" id="year_month" name="year_month">

<%--<form>--%>
<button type="submit">查询</button>
<%--    <input type="button" id="butt" onclick="alertValue()">--%>
</form>
</div>
<div style="margin: auto">
    当前年月：${year_month}<br>
    该月总收入：${allsum}  该月总订单:${allcount}
</div>
<script type="text/javascript" src="../../static/laydate.js"></script>
<script>
    laydate.render({
        elem: '#year_month'
        ,type: 'month'
    });
</script>

<div id="mainChart" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
<script type="text/javascript">
    var dom = document.getElementById("mainChart");
    var myChart = echarts.init(dom);



   var option = {
       tooltip:{
           trigger:'axis'
       },
       legend: {
           data:['订单数','订单总金额']
       },

        xAxis: {
            name: '日期',
            type: 'category',
            data: [
                <c:forEach items="${data}"  var="item">
                        "${item}日",
                </c:forEach>
    ] //选择五个就好了
            // data: ["1","2"] //选择五个就好了
        },
        yAxis: [{
            type:'value',
            name:'订单金额',
            axisLabel:{
                formatter:'{value}元'
            }
        },
            {
                type:'value',
                name:'订单数',
                axisLable:{
                    formatter:'{value}笔'
                }
            }

        ],
        series: [
            {
                name:'订单数',
                type:'line',
                smooth:0.2,
                yAxisIndex:1,
                data:[ <c:forEach items="${count}"  var="item">
                    "${item}",
                    </c:forEach>]
                // data:["1","2"]

            },
            {
                name:'订单总金额',
                type:'line',
                smooth:0.2,
                data:[ <c:forEach items="${sum}"  var="item">
                    "${item}",
                    </c:forEach>]
                // data:["2","3"]
            }]
    };
    myChart.setOption(option, true);

</script>


</body>
</html>

