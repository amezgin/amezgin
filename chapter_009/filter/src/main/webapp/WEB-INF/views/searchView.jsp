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
        <th>Password</th>
        <th>Role</th>
        <th>Email</th>
        <th>Create date</th>
    </tr>
    <c:if test="${searchedUser != null}">
        <tr>
            <td><c:out value="${searchedUser.name}"/>
            </td>
            <td><c:out value="${searchedUser.login}"/>
            </td>
            <td><c:out value="${searchedUser.password}"/>
            </td>
            <td><c:out value="${searchedUser.role.name}"/>
            </td>
            <td><c:out value="${searchedUser.email}"/>
            </td>
            <td><c:out value="${searchedUser.createDate}"/>
        </tr>
    </c:if>
    <c:if test="${searchedUser == null}">
        <p>User with login "<c:out value="${seachedUser.login}"/>" not found!</p>
    </c:if>
</table>
<br>
<form action="${pageContext.servletContext.contextPath}/" method="get">
    <button type="submit">Return to the home page!</button>
</form>
</body>
</html>