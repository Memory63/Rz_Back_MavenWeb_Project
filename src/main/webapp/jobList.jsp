<%--
  Created by IntelliJ IDEA.
  User: SDH
  Date: 2019/10/31
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>任务显示</title>
</head>
<body>
    <c:forEach items="${jobs}" var="j" varStatus="vs">
        ${j.jobName}---${j.jobGroup}---${j.jobClassName}---${j.triggerGroup}--${j.triggerName}---${j.cronExpression}---${j.timeZoneId}
    </c:forEach>
</body>
</html>
