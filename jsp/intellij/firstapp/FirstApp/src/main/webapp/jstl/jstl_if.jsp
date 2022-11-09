<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-09
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!-- 코어 태그 추가 -->
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${10 gt 0}">    <!-- gt = greater than (>) -->
    참일 때 보여집니다!
</c:if>
<hr>
이름 :
<c:if test="${members[1].name eq null}">    <!-- name=null 이니까 -->
    입력된 정보가 없습니다.
</c:if>
<hr>
<c:if test="${members[0].name == 'COOL0'}" var="result" scope="request"/>   <!-- request 영역에 있는 result에 boolean값 저장 -->
members[0].name == 'COOL0' => ${result}
</body>
</html>
