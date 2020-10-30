<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 28.10.2020
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add products</title>
</head>
<body>
<form method="post">
    <label>
        Podaj nazwę produktu:
        <input type="text" name="productName">
    </label>
    <label>
        Podaj cenę produktu:
        <input type="number" name="productPrice">
    </label>
    <label>
        Podaj id produktu:
        <input type="number" name="id">
    </label>
    <label>
        Podaj ilość produktu:
        <input type="number" name="quantity">
    </label>
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
