<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 28/09/2022
  Time: 8:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Bookshop Website</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },

                password: "required",
            },

            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },

                password: "Please enter password"
            }
        });

    });
</script>
 <div style="text-align: center">
     <h1>Admin Login</h1>
     <form action="login" method="post">
         <label for="email">Email:</label>
         <input name="email" size="30"/>
         <br><br>
         <label for="password">Password:</label>
         <input type="password" name="password" size="30"/>
         <br>${message}
         <br><br>
         <button type="submit">LogIn</button>
     </form>
 </div>
</body>
</html>
