<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 6:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원 가입</h1>
<hr>
<form method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" value="${memData.uid}"></td>
            <td>${valid_uid}</td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pw" value="${memData.pw}"></td>
            <td>${valid_pw}</td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="uname" value="${memData.uname}"></td>
            <td>${valid_uname}</td>
        </tr>
        <tr>
            <td>사진</td>
            <td><input type="file" name="uphoto"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="회원가입"></td>
        </tr>
    </table>
</form>
</body>
</html>
