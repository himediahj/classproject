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
<form method="post">
    <table>
        <tr>
            <td>할일</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>기한</td>
            <td><input type="date" name="dueDate"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="reset"><input type="submit" value="등록"></td>
        </tr>
    </table>
</form>
</body>
</html>
