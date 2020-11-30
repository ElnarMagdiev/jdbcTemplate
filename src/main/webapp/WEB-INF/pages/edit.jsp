<%--
  Created by IntelliJ IDEA.
  User: Магдиев
  Date: 27.11.2020
  Time: 14:20
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

<nav>
    <a href="/edit/add">Добавить вопрос</a>
        <ol type="1" style="display: table; margin:35px auto;">
            <c:forEach var="question" items="${questions}">
                <li>
                        ${question.content}
                    <a href="/edit/${question.id}">Редактировать</a>
                    <ol type="a">
                        <c:forEach var="answer" items="${question.answers}">
                            <li>
                                <input type="radio" name="${question.id}" value=${answer.id}>
                                    ${answer.content}
                            </li>
                        </c:forEach>
                    </ol>
                </li>
            </c:forEach>
        </ol>
</nav>
</body>
</html>
