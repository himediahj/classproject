<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-10
  Time: 오후 7:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="title" value="저장되어있는 할 일">
    <input type="date" name="date" value="2022-11-10"><br>
    <input type="submit" value="Modify">
</form>
<form action="/todo/remove" method="post">
    <input type="submit" value="Remove">
</form>
</body>
</html>
