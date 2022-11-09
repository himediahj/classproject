<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-09
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!-- 코어 태그 추가 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   <!-- -->
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("now", new Date());
%>
${now}  <!-- Wed Nov 09 17:18:04 KST 2022 -->
<hr>
<h3>날짜</h3>
<fmt:formatDate value="${now}"/><br>    <!-- 2022. 11. 9. -->
<fmt:formatDate value="${now}" type="date"/><br>    <!-- 2022. 11. 9. -->
<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>   <!-- 2022년 11월 9일 수요일 -->
<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>  <!-- 22. 11. 9. -->

<h3>시간</h3>
<fmt:formatDate value="${now}" type="time"/><br>    <!-- 오후 5:21:06 -->
<fmt:formatDate value="${now}" type="time" timeStyle="full"/><br>   <!-- 오후 5시 21분 54초 대한민국 표준시 -->
<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>  <!-- 오후 5:21 -->

<h3>both</h3>
<fmt:formatDate value="${now}" type="both"/><br>    <!-- 2022. 11. 9. 오후 5:22:57 -->
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>  <!-- 2022년 11월 9일 수요일 오후 5시 23분 41초 대한민국 표준시 -->

<h3>패턴</h3>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd a hh:mm"/><br> <!-- 소문자 m은 분 / a 넣으면 오후냐 오전이냐 뜸 / 대문자 HH는 24시 형식 -->
<fmt:formatDate value="${now}" pattern="yyyy. MM. dd. HH:mm:ss"/><br>   <!-- 2022. 11. 09. 17:26:38 -->
</body>
</html>
