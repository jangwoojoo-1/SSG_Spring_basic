<%@ page import="java.util.List" %>
<%@ page import="com.ssg.webmvc.todo.dto.TodoDTO" %><%--
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
        <c:forEach var="dto" items="${list}"><li>${dto}</li></c:forEach>
    </ul>

    <ul>
        <c:forEach var = "num" begin="1" end="10">
            <li>${num}</li>
        </c:forEach>
    </ul>

    <c:if test="${list.size() % 2 == 0}">
        짝수
    </c:if>
    <c:if test="${list.size() % 2 != 0}">홀수</c:if>

    <c:choose>
        <c:when test="${list.size() % 2 == 0}">홀수</c:when>
        <c:otherwise>홀수</c:otherwise>
    </c:choose>

    <c:set var="target" value="5"></c:set>
    <ul>
        <c:forEach var="num" begin="1" end="10">
            <c:if test="${num == target}">
                num is target
            </c:if>
        </c:forEach>
    </ul>

    <a href=""></a>

</body>
</html>
