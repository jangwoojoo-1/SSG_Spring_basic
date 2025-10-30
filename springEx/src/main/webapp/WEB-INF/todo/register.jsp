<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-23
  Time: 오전 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/todo/register" method="post">
        <input type="text" name="title" placeholder="INSERT TITLE"><br>
        <input type="date" name="curDate"><br>
        <input type="reset" value="reset">
        <input type="submit" value="submit">
    </form>

</body>
</html>
