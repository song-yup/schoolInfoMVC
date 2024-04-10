<%--
  Created by IntelliJ IDEA.
  User: songs
  Date: 2024-04-05
  Time: 오후 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docourses" modelAttribute="course">
    <table class="formtable">
        <tr>
            <td class="label">교과코드</td>
            <td><sf:input class="control" type="text" path="id" /> <br/>
                <sf:errors path="id" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label">교과목명</td>
            <td><sf:input class="control" type="text" path="name" /> <br/>
                <sf:errors path="name" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label">년도</td>
            <td><sf:input class="control" type="text" path="year" /> <br/>
                <sf:errors path="year" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label">학기</td>
            <td><sf:input class="control" type="text" path="semester" /> <br/>
                <sf:errors path="semester" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label">교과구분</td>
            <td><sf:input class="control" type="text" path="classification" /> <br/>
                <sf:errors path="classification" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label">담당교수</td>
            <td><sf:input class="control" type="text" path="professor" /> <br/>
                <sf:errors path="professor" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label">학점</td>
            <td><sf:input class="control" type="text" path="score" /> <br/>
                <sf:errors path="score" class="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="새 수강신청"/> </td>
        </tr>
    </table>
</sf:form>

</body>
</html>
