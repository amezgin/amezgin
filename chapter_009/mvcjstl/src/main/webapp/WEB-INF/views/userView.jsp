<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h3>Create the new user</h3>
<form action="${pageContext.servletContext.contextPath}/create" method="post">
    Name: <input type="text" name="name"/>
    Login: <input type="text" name="login"/>
    Email: <input type="text" name="email"/>
    <input type="submit" value="create"/>
</form>
<br>
<h3>Search the user</h3>
<form action="${pageContext.servletContext.contextPath}/search" method="post">
    Login: <input type="text" name="login"/>
    <input type="submit" value="search"/>
</form>
<br>
<h3>List of users</h3>
<table border=\"1\">
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Email</th>
        <th>Create date</th>
        <th>Edit user</th>
        <th>Delete user</th>
    </tr>
    <c:forEach items="${usersList}" var="user">
    <tr>
        <td><c:out value="${user.name}"/>
        </td>
        <td><c:out value="${user.login}"/>
        </td>
        <td><c:out value="${user.email}"/>
        </td>
        <td><c:out value="${user.createDate}"/>
        <td>
            <form action="${pageContext.servletContext.contextPath}/update" method="get">
                <input type="hidden" name="login" value="${user.login}">
                <button type="submit">Edit user</button>
            </form>
        </td>
        <td>
            <form action="${pageContext.servletContext.contextPath}/delete" method="post">
                <input type="hidden" name="login" value="${user.login}"/>
                <button type="submit">Delete user</button>
            </form>
        </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>