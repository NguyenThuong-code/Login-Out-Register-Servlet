<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/09/2022
  Time: 10:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin CPanel - Bookshop</title>
</head>
<body>
<div style="text-align: center">
    <h1>Welcome to Bookshop Website Admin Panel</h1>
    <b>${user.name} (${user.getEmail()})</b>
    <br><br>
    <a href="/logout">Logout</a>
</div>

</body>
</html>
