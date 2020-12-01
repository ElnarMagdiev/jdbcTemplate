<%--
  Created by IntelliJ IDEA.
  User: Магдиев
  Date: 30.11.2020
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/edit/${question.id}">
    <input type="text" name="question" value="${question.content}">
    <ol type="a">
        <c:forEach var="i" begin="0" end="3">
            <li>
                <input type="hidden" name="id_${i}" value="${!empty question.answers[i].id ? question.answers[i].id:''}">
                <input type="text" name="answer_content_${i}" id="answer_content_${i}"
                       value="${!empty question.answers[i].content ? question.answers[i].content : ''}">

                <c:if test="${question.answers[i].correct == true}">
                    <input type="radio" name="answer_isCorrect" value="${i}" checked>
                </c:if>
                <c:if test="${question.answers[i].correct != true}">
                    <input type="radio" name="answer_isCorrect" value="${i}">
                </c:if>
            </li>
            <br>
        </c:forEach>
    </ol>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
