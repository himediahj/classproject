<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-10
  Time: 오후 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" name="title" value="저장되어있는 할 일">
<input type="date" name="date" value="2022-11-10">
<a href="/todo/modify?no=${param.no}">Modify/Remove</a>
<a href="/todo/list">List</a>
</body>
</html>
