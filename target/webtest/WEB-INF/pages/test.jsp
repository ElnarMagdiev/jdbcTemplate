<%--
  Created by IntelliJ IDEA.
  User: Магдиев
  Date: 27.11.2020
  Time: 12:57
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
    <form method="post" action="/submit">
        <ol type="1" style="display: table; margin:35px auto;">
            <c:forEach var="question" items="${questions}">
                <li>
                        ${question.content}
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
        <br>
        <div style="text-align: center">
            <button name="submit" type="submit">Завершить</button>
        </div>
    </form>
</nav>
</body>
</html>
