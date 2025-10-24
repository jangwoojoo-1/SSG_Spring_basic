<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-23
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PostModify</title>
    <style>
        form{
            display: flex;
            flex-direction: column;
        }
    </style>
    <script>
        function modify(){
            const form = document.querySelector('form');
            form.method = "post";
            form.action = "/todo/modify"
            form.submit();
        }
        function remove(){
            const form = document.querySelector('form');
            form.method = "post";
            form.action = "/todo/remove"
            form.submit();
        }
    </script>
</head>
<body>
    <form>
        <input type="text" name="readTno" value="${post.getTno()}" readonly>
        <input type="text" name="readTitle" value="${post.getTitle()}">
        <input type="date" name="readDueDate" value="${post.getDueDate()}">
        <input type="checkbox" name="readFinished" value="true" ${post.isFinished() ? "checked" : ""} readonly>
        <button onclick="modify()">Modify</button>
        <button onclick="remove()">Remove</button>
    </form>
</body>
</html>
