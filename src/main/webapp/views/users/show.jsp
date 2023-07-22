<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 22.07.2023
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Card</title>
</head>
<%@ page import="ru.andrew.test11.models.User" %>
<%@ page import="java.util.*" %>

<h1>User Card</h1>

<table>
        <%User user = (User) request.getAttribute("user");%>
    <tr>
        <td>ID</td><td><%=user.getId()%></td>
    </tr>
    <tr>
        <td>Name</td><td><%=user.getUser_name()%></td>
    </tr>
</html>
