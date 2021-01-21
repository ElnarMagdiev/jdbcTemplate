<%--
  Created by IntelliJ IDEA.
  User: Магдиев
  Date: 26.12.2020
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label>Пользователь: ${user}</label><br>
<label>Вопросов: ${questionCount}</label><br>
<label>Правильных ответов: ${score}</label><br>
<label>Пройдено: ${percent}%</label><br>
<c:choose>
    <c:when test="${complete}">
       <label>Тест пройден</label><br>
    </c:when>
    <c:otherwise>
        <label>Тест провален</label><br>
    </c:otherwise>
</c:choose>
<br>
<a href="/">На главную</a>
</body>
</html>
