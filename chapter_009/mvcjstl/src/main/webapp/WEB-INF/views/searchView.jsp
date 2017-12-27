<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searched User</title>
</head>
<body>
<h3>The searched user</h3>
<table border=\"1\">
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Email</th>
        <th>Create date</th>
    </tr>
    <c:if test="${user != null}">
        <tr>
            <td><c:out value="${user.name}"/>
            </td>
            <td><c:out value="${user.login}"/>
            </td>
            <td><c:out value="${user.email}"/>
            </td>
            <td><c:out value="${user.createDate}"/>
            </td>
        </tr>
    </c:if>
    <c:if test="${user == null}">
        <p>User with login "<c:out value="${user.login}"/>" not found!</p>
    </c:if>
</table>
<br>
<form action="${pageContext.servletContext.contextPath}/" method="get">
    <button type="submit">Return to the home page!</button>
</form>
</body>
</html>