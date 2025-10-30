<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-23
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        form{
            display: flex;
            flex-direction: column;
        }
    </style>
</head>
<body>
    <form>
        <input type="text" name="readTno" value="${post.getTno()}" readonly>
        <input type="text" name="readTitle" value="${post.getTitle()}" readonly>
        <input type="date" name="readDueDate" value="${post.getDueDate()}" readonly>
        <input type="checkbox" name="readFinished" value="true" ${post.isFinished() ? "checked" : ""} disabled>
    </form>
    <p><a href="/todo/modify?readTno=${post.getTno()}">ModifyRemove</a>&nbsp;<a href="/todo/list">List</a></p>
</body>
</html>
