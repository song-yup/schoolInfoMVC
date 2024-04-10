<%--
  Created by IntelliJ IDEA.
  User: songs
  Date: 2024-04-03
  Time: 오후 4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학사 정보 시스템</title>
</head>
<body>
    <h2>학사 정보 시스템</h2>
    <p> <a href="${pageContext.request.contextPath}/login">로그인</a> </p>
    <p> <a href="${pageContext.request.contextPath}/showcourses">학년별 이수 학점 조회</a></p>
    <p> <a href="${pageContext.request.contextPath}/createcourses">수강 신청하기</a></p>
    <p> <a href="${pageContext.request.contextPath}/showcreatedcourses">수강 신청 조회</a></p>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="javascript:document.getElementById('logout').submit()">로그아웃</a>
    </c:if>

    <form id="logout"  action="<c:url value="/logout" />"method="post">
        <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
    </form>
</body>
</html>
