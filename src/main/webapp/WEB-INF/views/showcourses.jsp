<%--
  Created by IntelliJ IDEA.
  User: songs
  Date: 2024-04-03
  Time: 오후 5:29
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
                <th><p>년도</p></th>
                <th><p>학기</p></th>
                <th><p>취득학점</p></th>
                <th><p>상세보기</p></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="courses" items="${id_coursesummary}" >
                <tr>
                    <td><p> <c:out value="${courses.year}"></c:out> </p></td>
                    <td><p> <c:out value="${courses.semester}"></c:out> </p></td>
                    <td><p> <c:out value="${courses.totalScore}"></c:out> </p></td>
                    <td><p> <a href="${pageContext.request.contextPath}/showdetailcourses/${courses.year}/${courses.semester}">링크</a> </p></td>
                </tr>
            </c:forEach>
            <c:forEach var="courses" items="${id_allscores}">
                <tr>
                    <td><p>총계</p></td>
                    <td></td>
                    <td><p><c:out value="${courses.alltotalScore}"></c:out></p></td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>