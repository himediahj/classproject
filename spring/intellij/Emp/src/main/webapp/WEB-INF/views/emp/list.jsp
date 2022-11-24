<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 4:13
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
<h1>Emp List</h1>
<hr>
<table border="1">
  <tr>
    <th>사원번호</th>
    <th>사원이름</th>
    <th>담당업무</th>
    <th>매니저사번</th>
    <th>입사일</th>
    <th>급여</th>
    <th>커미션</th>
    <th>부서번호</th>
    <th>관리</th>
  </tr>
  <c:forEach var="emp" items="${list}">
    <tr>
      <td>${emp.empno}</td>
      <td>${emp.ename}</td>
      <td>${emp.job}</td>
      <td>${emp.mgr}</td>
      <td>${emp.hiredate}</td>
      <td>${emp.sal}</td>
      <td>${emp.comm}</td>
      <td>${emp.deptno}</td>
      <td><a href="/emp/modify?no=${emp.empno}" style="text-decoration: none">수정</a> / <a onclick="deleteEmp(${emp.empno});" style="cursor: pointer">삭제</a></td>
    </tr>
  </c:forEach>
</table>
<br>
<a href="/emp/register">사원 등록하기</a>

<script>
  function deleteEmp(no){
    if(confirm("삭제하시겠습니까?")){
      location.href = '/emp/delete?empno=' + no;
    }
  }
</script>
</body>
</html>
