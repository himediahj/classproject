<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 12:51
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
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Dept List</h1>
<hr>
<a href="/dept/register">부서 등록</a>

<div style="margin-top: 10px">
    <form>
        검색
        <select name="searchType">
            <option value="dname">부서이름</option>
            <option value="loc">부서위치</option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="검색">
    </form>
</div>
<br>
<table border="1">
    <tr>
        <th>부서번호</th>
        <th>부서이름</th>
        <th>부서위치</th>
        <th>관리</th>
    </tr>
    <c:forEach var="list" items="${deptList}">
        <tr>
            <td>${list.deptno}</td>
            <td>${list.dname}</td>
            <td>${list.loc}</td>
            <td><a href="/dept/edit?no=${list.deptno}">수정</a> / <a onclick="deleteDept(${list.deptno});" style="cursor: pointer">삭제</a></td>
        </tr>
    </c:forEach>
</table>
<script>
    function deleteDept(no){
        if(confirm("삭제하시겠습니까?")){
            location.href = '/dept/delete?deptno='+no;
        }
    }
</script>
</body>
</html>
