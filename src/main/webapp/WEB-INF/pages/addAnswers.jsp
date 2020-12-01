<%--
  Created by IntelliJ IDEA.
  User: Магдиев
  Date: 30.11.2020
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Web test</title>
    <link href="<c:url value="/resources/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
${question.content}
<form action="/edit/add/${question.id}/answers" method="post">
    <ol type="a">
        <input type="hidden" name="id_question" value="${question.id}">
        <c:forEach var="i" begin="0" end="3">
        <li>
            <input type="text" name="answer_content_${i}" id="answer_content_${i}">

            <c:choose>
                <c:when test="${i==0}">
                    <input type="radio" name="answer_isCorrect" value="${i}" checked>
                </c:when>
                <c:otherwise>
                    <input type="radio" name="answer_isCorrect" value="${i}">
                </c:otherwise>
            </c:choose>
        </li>
        <br>
        </c:forEach>
        <br>
        <br>
        <input type="submit" value="Сохранить">
</form>
<a href="/edit/">Назад</a>
</body>
</html>
