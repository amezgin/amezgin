<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h3>Enter the new data for user!</h3>
<c:if test="${admin == 'yes'}">
    <form action="${pageContext.servletContext.contextPath}/update" method="post">
        <input type="hidden" name="oldLogin" value="${user.login}"/>
        Name: <input type="text" name="name"/>
        Login: <input type="text" name="login"/>
        Password: <input type="text" name="password"/>
        Role: <select size="1" name="role">
        <option value="1">ADMIN</option>
        <option value="2">USER</option>
    </select>
        Email: <input type="text" name="email"/>
        <input type="submit" value="update"/>
    </form>
</c:if>
<c:if test="${admin == null}">
    <form action="${pageContext.servletContext.contextPath}/update/user" method="post">
        <input type="hidden" name="oldLogin" value="${user.login}"/>
        Name: <input type="text" name="name"/>
        Login: <input type="text" name="login"/>
        Password: <input type="text" name="password"/>
        Email: <input type="text" name="email"/>
        <input type="submit" value="update"/>
    </form>
</c:if>
</body>
</html>