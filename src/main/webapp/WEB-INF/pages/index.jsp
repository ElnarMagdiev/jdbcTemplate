<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>

<ol type="1">

    <c:forEach var="question" items="${questions}">
        <li>
                ${question.content}
            <input type="hidden" name="questionId" value="${question.id}">
            <ol type="a">
                <c:forEach var="answer" items="${question.answers}">
                    <li>
                        <input type="radio" name="question_${question.id}" value=${answer.id}>
                            ${answer.content}
                    </li>
                </c:forEach>
            </ol>
        </li>
    </c:forEach>
</ol>

</body>
</html>
