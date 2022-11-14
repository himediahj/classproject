<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-11
  Time: 오후 6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <td>번호</td>
    <td>할일</td>
    <td>기간</td>
    <td>완료여부</td>
  </tr>

  <c:forEach var="todo" items="${list}">
    <tr style="<c:if test="${todo.finished eq 'true'}">text-decoration:line-through</c:if>">
      <td><a href="/todo/read?tno=${todo.tno}">${todo.tno}</a></td>
      <td>${todo.title}</td>
      <td>${todo.dueDate}</td>
      <td>${todo.finished ? '완료' : '진행중'}</td>
    </tr>
  </c:forEach>



</table>

<br>
<a href="/todo/register">Todo 등록하기</a>

</body>
</html>
