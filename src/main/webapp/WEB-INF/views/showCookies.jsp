<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 29.10.2020
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${cookies}" var="item">
    <p> ${item.name}</p>
    <p>${item.value}</p>
</c:forEach>
</body>
</html>
