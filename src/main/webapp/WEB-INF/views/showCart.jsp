<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 28.10.2020
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cart</title>
    <style>
        table{
            width: 50%;
            border: 2px solid;
        }
        thead{
            background-color: gray;
            color: white;
        }
        tbody{
            background-color: aliceblue;
            color: black;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>Product name</td>
        <td>Product price</td>
        <td>Product id</td>
        <td>Product quantity</td>
        <td>Add one piece</td>
        <td>Remove one piece</td>
        <td>Remove product</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cartItems}" var="item">
        <tr>
            <td>${item.product.name}</td>
            <td>${item.product.price}</td>
            <td>${item.product.id}</td>
            <td>${item.quantity}</td>
            <td><a href="/addOnePiece?id=${item.product.id}">Add one piece</a> </td>
            <td><a href="/removeOnePiece?id=${item.product.id}">Remove one piece</a> </td>
            <td><a href="/removeProduct?id=${item.product.id}">Remove product</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
