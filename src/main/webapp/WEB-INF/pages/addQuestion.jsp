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
<h3>Добавьте вопрос</h3>
<form action="/edit/add" method="post">
    <input type="text" name="question" id="content" size="50">
    <br>
    <br>
    <input type="submit" value="Сохранить">
</form>
<a href="/edit/">Назад</a>
</body>
</html>
