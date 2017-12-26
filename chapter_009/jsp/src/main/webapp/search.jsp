<%@ page import="ru.job4j.models.User" %>
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
    <% User user = (User) request.getAttribute("user");
        {%>
    <% if (user != null) {%>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getLogin()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td><%=user.getCreateDate().toString()%>
        </td>
    </tr>
    <% } else { %>
    User with login "<%=request.getParameter("login")%>" not found!
    <% } %>
    <% } %>
</table>
<br>
<form action="<%request.getContextPath();%>/index.jsp" method="get">
    <button type="submit">Return to the home page!</button>
</form>
</body>
</html>