<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 19.07.2023
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ page import="ru.andrew.test11.models.User" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<table>
    <%
        List<User> userList;
        userList = (List<User>) request.getAttribute("userList");
        for (User user: userList) {
    %>
    <tr>
        <td><%=user.getId()%></td><td><%=user.getUser_name()%></td>
            <%}%>

</table>
</body>
</html>
