
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<h3>Enter the new data for user!</h3>
<form action="<%request.getContextPath();%>/update" method="post">
    <input type="hidden" name="oldLogin" value="<%=request.getParameter("login")%>"/>
    Name: <input type="text" name="name"/>
    Login: <input type="text" name="login"/>
    Email: <input type="text" name="email"/>
    <input type="submit" value="update"/>
</form>
</body>
</html>
