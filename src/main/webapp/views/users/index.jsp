<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 22.07.2023
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<%@ page import="ru.andrew.test11.models.User" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<table>
  <%
    PrintWriter pw = response.getWriter();
    List<User> userList;
    userList= (List<User>) request.getAttribute("userList");
    for (User user: userList) {
  %>
  <tr>
    <td><%=user.getId()%></td>
    <td><%=user.getUser_name()%></td>
    <td><%=user.getBirthdate()%></td>
    <td><a href = "/users-controller?id=<%=user.getId()%>"> Card </a></td>
    <td><a href = "/views/users/edit.jsp?id=<%=user.getId()%>&user_name=<%=user.getUser_name()%>&birthdate=<%=user.getBirthdate()%>">Edit</a></td>
    <td><a href = "/views/users/delete.jsp?id=<%=user.getId()%>&user_name=<%=user.getUser_name()%>">Delete</a>
        <%}%>

</table>
<a href = "/views/users/new.jsp"><button>Add</button></a>
</body>
</html>
