<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오전 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>Todo Modify</h1>
<%--@elvariable id="todoDTO" type="com.spring.todolist.domain.TodoDTO"--%>
<form:form modelAttribute="todoDTO" method="post">
<table>
    <tr>
        <td>번호</td>
        <td><input type="text" name="tno" value="${todo.tno}" readonly></td>
    </tr>
    <tr>
        <td>할일</td>
        <td><input type="text" name="title" value="${todo.title}"></td>
        <td><form:errors path="title"/> </td>
    </tr>
    <tr>
        <td>기한</td>
        <td><input type="date" name="dueDate" value="${todo.dueDate}"></td>
        <td><form:errors path="dueDate"/> </td>
    </tr>
    <tr>
        <td>상태</td>
        <td><input type="checkbox" name="finished" ${todo.finished? 'checked':''}></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="reset"><input type="submit" value="수정"></td>
    </tr>
</table>
</form:form>

<form action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${param.tno}">
    <input type="submit" value="삭제">
</form>
<br>
<a href="/todo/list">Todo List</a>
</body>
</html>
