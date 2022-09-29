<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 29/09/2022
  Time: 2:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Fill in The Form User</title>
</head>
<body>
<div align="center">
    <h1>User Register Form</h1>
    <c:if test="${not empty succMsg }">
        <p class="text-center text-success">${succMsg }</p>
        <c:remove var="succMsg" scope="session"/>
    </c:if>

    <c:if test="${not empty failedMsg}">
        <p class="text-center text-danger">${failedMsg }</p>
        <c:remove var="failedMsg" scope="session"/>
    </c:if>
    <form action="/register" method="post">
        <table style="with: 80%">
            <tr>
                <td>UserName</td>
                <td><input type="text" required="required"  name="name" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" required="required"  name="email" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" required="required"  name="password" /></td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td><input type="text" required="required"  name="phone" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text"  required="required"  name="address" /></td>
            </tr>
        </table>
        <div class="form-check">
            <input type="checkbox" class="form-check-input" name="check"
                   id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Agree term & Condition</label>
        </div>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
