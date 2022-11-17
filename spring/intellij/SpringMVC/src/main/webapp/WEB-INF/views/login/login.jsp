<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 완료 페이지</h1>
<h3>loginRequest : ${loginRequest}</h3>    <!-- 이름을 따로 지정하지 않았기 때문에 클래스이름 앞에 소문자로 변경되서 받음 LoginRequest(uid=cool, pw=123456789) -->
<!-- 이름 지정하려면 @ModelAttribute ; 특정 객체를 view로 공유할 때 -->
<h3>req : ${req}</h3> <!-- req로 이름 붙였기 때문에 위에서는 안나오고 여기서 LoginRequest(uid=cool, pw=123456789) 나옴 -->
</body>
</html>
