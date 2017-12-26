<%@ page import="ru.job4j.models.User" %>
<%@ page import="ru.job4j.UserStore" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h3>Create the new user</h3>
<form action="<%request.getContextPath();%>/create" method="post">
    Name: <input type="text" name="name"/>
    Login: <input type="text" name="login"/>
    Email: <input type="text" name="email"/>
    <input type="submit" value="create"/>
</form>
<br>
<h3>Search the user</h3>
<form action="<%request.getContextPath();%>/search" method="post">
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
    <% for (User user : UserStore.getInstance().getAllUser()) {%>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getLogin()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td><%=user.getCreateDate().toString()%>
        </td>
        <td>
            <form action="<%request.getContextPath();%>/update" method="get">
                <input type="hidden" name="login" value="<%=user.getLogin()%>"/>
                <button type="submit">Edit user</button>
            </form>
        </td>
        <td>
            <form action="<%request.getContextPath();%>/delete" method="post">
                <input type="hidden" name="login" value="<%=user.getLogin()%>"/>
                <button type="submit">Delete user</button>
            </form>
        </td>
        <% } %>
    </tr>
</table>
</body>
</html>