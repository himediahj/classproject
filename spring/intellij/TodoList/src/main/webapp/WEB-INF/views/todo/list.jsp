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

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/bootstrap/offcanvas.css" rel="stylesheet">

    <style>
        th,td {
            text-align: center;
            padding: 5px;
        }

        .container {
            margin-top: 100px;
        }

        .btn btn-dark {
            margin-right: auto;
        }

    </style>
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <a class="navbar-brand mr-auto mr-lg-0" href="#">Todo List</a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
    </button>
    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

    <main role="main" class="container">

<h1>Todo List</h1>
<table class="table table-striped">
    <thead class="thead-dark">
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
            <td>${todo.finished? '완료':'진행중'}</td>
        </tr>
    </c:forEach>
</table>
<br>
<button type="button" class="btn btn-primary" onclick="location.href='/todo/register'">Todo 등록하기</button>
        <button type="button" class="btn btn-dark" onclick="location.href='/logout'">로그아웃</button>
    </main>

</body>
</html>
