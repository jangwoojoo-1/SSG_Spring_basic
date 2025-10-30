<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %>  <!-- %= print 함수 -->
    <h1><%= "Hello World!" %></h1>
    <h1><%= "Hello World!" %></h1>
<br/>
<%--        a태그는 get요청만 가능 --%>
    <a href="/hello">Hello Servlet</a><br>
        <a href="/my">MyServlet</a><br>
        <a href="/first">firstServlet</a><br>
        <a href="/member">memberList</a>
</body>
</html>