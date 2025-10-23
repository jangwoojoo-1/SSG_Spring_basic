<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-22
  Time: 오후 5:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function(){

        }
    </script>
</head>
<body>
    <h2>회원가입 결과</h2>

    <p><%= request.getAttribute("message") %></p>

    <a href="memberRegister.html">첫화면으로</a>
</body>
</html>
