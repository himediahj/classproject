<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<h1>Todo Read</h1>
<table>
    <tr>
        <td>번호</td>
        <td><input type="text" name="tno" readonly></td>
    </tr>
    <tr>
        <td>할일</td>
        <td><input type="text" name="title" readonly></td>
    </tr>
    <tr>
        <td>기한</td>
        <td><input type="date" name="dueDate" readonly></td>
    </tr>
    <tr>
        <td>상태</td>
        <td><input type="checkbox" name="finished" disabled></td>
    </tr>
</table>
<a href="/todo/modify">Modify/Remove</a> <a href="/todo/list">Todo List</a>
</body>
</html>
