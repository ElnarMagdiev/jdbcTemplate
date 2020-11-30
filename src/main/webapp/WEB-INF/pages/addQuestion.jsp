<%--
  Created by IntelliJ IDEA.
  User: Магдиев
  Date: 30.11.2020
  Time: 12:18
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
<form action="/edit/add" method="post">
    <h3>Вопрос</h3>
    <input type="text" name="content" id="content" size="50">
    <br>
    <br>
    <h4>Варианты ответа</h4>
   <c:forEach var="i" begin="0" end="3">
        <input type="text" name="answer${i}" id="${i}">

   </c:forEach>

    <br>
    <br>
    <input type="submit" value="Сохранить">
</form>
<a href="/edit/">Назад</a>
</body>
</html>
