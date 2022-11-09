<%@ page import="com.firstcoding.firstapp.member.Member" %>
<%@ page import="com.firstcoding.firstapp.product.Product" %><%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-09
  Time: 오후 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("name", "손흥민");
    //////////////////////////////////////
    session.setAttribute("name", "이강인");
    //////////////////////////////////////
    Member member = new Member();
    member.setId("cool");
    member.setPw("1234");
    member.setName("COOL");

    session.setAttribute("member", member);

    //////////////////////////////////////
    session.setAttribute("product", new Product());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>표현식 : <%=request.getAttribute("name")%></h4>
    <h4>표현언어 : ${requestScope.name}</h4>

    <h4>표현식 : <%=request.getAttribute("id")%></h4>  <!-- null 반환 -->
    <h4>표현언어 : ${requestScope.id}</h4>  <!-- 아무것도 나오지 않음 -->

    <h4> param (code) : ${param.code}</h4>  <!-- 주소창에 ?code=값 입력하면 값 나옴 -->

    <h4> pageContext : ${pageContext.request.requestURL}</h4>   <!-- http://localhost:8080/el/elObj.jsp -->
    <h4> pageContext : ${pageContext.request.requestURI}</h4>   <!-- /el/elObj.jsp -->
    <h4> contextpath : ${pageContext.request.contextPath}</h4>  <!-- getContextPath() 메소드 호출 -->
    <!-- Tomcat edit - deployment - /뒤에 입력하면 나옴 -->

<!--/////////////////////////////////////////////////-->
    <h4> sessionScope (name) : ${sessionScope.name}</h4>
    <h4> (name) : ${name}</h4>  <!-- scope 생략 ; 손흥민 출력 ; request -> session -> application 순서라서 -->

<hr>

${true} / ${false} / ${100} / ${1.2} / ${'손흥민'} / ${null} <!-- null이라 안나옴 -->

<hr>

    <h4>${sessionScope.member}</h4>
    <h4>
        ${member} / ${member.id} / ${member.pw} / ${member.name} / ${member.info} <!-- get 메소드 호출 -->
    </h4>

<hr>

    <h4> 첫번째 상품 : ${product.list[0]}, 가격 : ${product.price}</h4>
</body>
</html>
