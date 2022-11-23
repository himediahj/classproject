<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-23
  Time: 오후 6:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        td {
            padding: 5px;
        }
    </style>
</head>
<body>
<h1>Todo List</h1>
<table>
    <tr>
        <th>번호</th>
        <th>할일</th>
        <th>기간</th>
        <th>완료여부</th>
    </tr>
    <c:forEach var="todo" items="${list}">
        <tr>
            <td><a href="/todo/read?tno=${todo.tno}">${todo.tno}</a></td>
            <td>${todo.title}</td>
            <td>${todo.dueDate}</td>
            <td>${todo.finished}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/todo/register">Todo 등록하기</a>
</body>
</html>
