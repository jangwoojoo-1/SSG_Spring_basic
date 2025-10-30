<%@ page import="java.util.List" %>
<%@ page import="com.ssg.springex.todo.dto.TodoDTO" %><%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-23
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TodoList</title>
</head>
<body>
    <h1>Todo List</h1>
<%--    EL(Expression Language)

 --%>
    <ul>
        <c:forEach var="dto" items="${dtoList}">
            <li>
                <a href="/todo/read?tno=${dto.getTno()}">${dto.getTno()}</a>&nbsp;
                ${dto.getTitle()}&nbsp;
                ${dto.getDueDate()}&nbsp;
                <c:if test="${dto.isFinished()}">Done</c:if>
                <c:if test="${not dto.isFinished()}">Not Yet</c:if>
            </li>
        </c:forEach>
    </ul>
    <form action="/todo/register" method="get">
        <input type="submit" value="LOGOUT">
    </form>

</body>
</html>
