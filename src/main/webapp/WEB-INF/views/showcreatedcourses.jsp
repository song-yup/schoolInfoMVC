<%--
  Created by IntelliJ IDEA.
  User: songs
  Date: 2024-04-06
  Time: 오후 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th><p>교과코드</p></th>
        <th><p>년도</p></th>
        <th><p>학기</p></th>
        <th><p>교과목명</p></th>
        <th><p>교과구분</p></th>
        <th><p>담당교수</p></th>
        <th><p>학점</p></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="courses" items="${id_newcourse}" >
        <tr>
            <td><p> <c:out value="${courses.id}"></c:out> </p></td>
            <td><p> <c:out value="${courses.year}"></c:out> </p></td>
            <td><p> <c:out value="${courses.semester}"></c:out> </p></td>
            <td><p> <c:out value="${courses.name}"></c:out> </p></td>
            <td><p> <c:out value="${courses.classification}"></c:out> </p></td>
            <td><p> <c:out value="${courses.professor}"></c:out> </p></td>
            <td><p> <c:out value="${courses.score}"></c:out> </p></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
