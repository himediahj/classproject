<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-09
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .red{
            color: red;
        }
    </style>
</head>
<body>
${members}
<hr>
<br>
${members[0]}
<br>
${members[1]} / ${members[1].name}  <!-- .name은 null이라 안 나옴 -->
<br><br>
<c:out value="${members[0].name}">  <!-- COOL0 -->
    <span class="red">입력정보 없음</span>
</c:out>
<br>
<c:out value="${members[1].name}" escapeXml="false">
    <span class="red">입력정보 없음</span>    <!-- null이니까 default값으로 입력정보 없음이 나옴 -->
</c:out>
<!-- out의 기능 : 값이 null일 때 default값 나오게 하려고 -->
</body>
</html>
