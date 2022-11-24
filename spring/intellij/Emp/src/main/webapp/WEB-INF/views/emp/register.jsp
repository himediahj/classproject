<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>사원 등록</h1>
<hr>
<form method="post">
  <table>
    <tr>
      <td>사원이름</td>
      <td><input type="text" name="ename"></td>
    </tr>
    <tr>
      <td>담당업무</td>
      <td><input type="text" name="job"></td>
    </tr>
    <tr>
      <td>매니저사번</td>
      <td><input type="number" name="mgr"></td>
    </tr>
    <tr>
      <td>입사일</td>
      <td><input type="date" name="hiredate"></td>
    </tr>
    <tr>
      <td>급여</td>
      <td><input type="number" name="sal"></td>
    </tr>
    <tr>
      <td>커미션</td>
      <td><input type="number" name="comm"></td>
    </tr>
    <tr>
      <td>부서번호</td>
      <td><input type="number" name="deptno"></td>
    </tr>
    <tr><td></td>
      <td><input type="submit" value="등록하기"></td>
    </tr>
  </table>
</form>
</body>
</html>
