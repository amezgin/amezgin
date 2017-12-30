<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<div style="position: fixed; right:0; z-index:500;">
    <form action="${pageContext.servletContext.contextPath}/userSignout" method="post">
        <button type="submit">signout</button>
    </form>
</div>
<table border=\"1\">
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th>Email</th>
        <th>Create date</th>
        <th>Edit user</th>
    </tr>
    <tr>
        <td><c:out value="${user.name}"/>
        </td>
        <td><c:out value="${user.login}"/>
        </td>
        <td><c:out value="${user.password}"/>
        </td>
        <td><c:out value="${user.email}"/>
        </td>
        <td><c:out value="${user.createDate}"/>
        <td>
            <form action="${pageContext.servletContext.contextPath}/update/user" method="get">
                <input type="hidden" name="login" value="${user.login}">
                <button type="submit">Edit user</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>