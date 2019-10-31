<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/10/31
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加定时任务</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/quartz/add" method="post">
        jobName: <input type="text" name="jobName"> <br>
        jobGroup: <input type="text" name="jobGroup"> <br>
        cronExp: <input type="text" name="cronExpression"> <br>
        jobClass: <input type="text" name="jobClassName"> <br>
        <input type="submit" value="增加">
    </form>
</body>
</html>
