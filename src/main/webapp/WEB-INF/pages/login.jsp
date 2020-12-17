<%--
  Created by IntelliJ IDEA.
  User: Магдиев
  Date: 17.12.2020
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="/login">
    <table border="0" cellspacing="5">
        <tr>
            <th align="right">Username:</th>
            <td align="left"><input type="text" name="username"></td>
        </tr>
        <tr>
            <th align="right">Password:</th>
            <td align="left"><input type="password" name="password"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="Log In"></td>
            <td align="left"><input type="reset"></td>
        </tr>
    </table>
</form>

</body>
</html>
