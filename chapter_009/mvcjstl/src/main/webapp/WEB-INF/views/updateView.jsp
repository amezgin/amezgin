<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h3>Enter the new data for user!</h3>
<form action="${pageContext.servletContext.contextPath}/update" method="post">
    <input type="hidden" name="oldLogin" value="${user}"/>
    Name: <input type="text" name="name"/>
    Login: <input type="text" name="login"/>
    Email: <input type="text" name="email"/>
    <input type="submit" value="update"/>
</form>
</body>
</html>