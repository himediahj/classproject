<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-23
  Time: 오후 6:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo Register</h1>
<%--@elvariable id="todoDTO" type="com.spring.todolist.domain.TodoDTO"--%>
<form:form modelAttribute="todoDTO" method="post">
    <table>
        <tr>
            <td>할일</td>
            <td><input type="text" name="title"></td>
            <td><form:errors path="title"/></td>
        </tr>
        <tr>
            <td>기한</td>
            <td><input type="date" name="dueDate"></td>
            <td><form:errors path="dueDate"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="reset"><input type="submit" value="등록"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
