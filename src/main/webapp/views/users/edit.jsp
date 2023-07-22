<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 22.07.2023
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<form method = "post" action = "/users-controller">
    <p>
        Id <input name = "id" value = "<%=request.getParameter("id")%>">
    </p>
    <br>
    <p>
        Name <input name = "user_name" value = "<%=request.getParameter("user_name")%>">
    </p>
    <br>
    <p>
        Birthdate <input name = "birthdate" value = "<%=request.getParameter("birthdate")%>">
    </p>
    <br>
    <p>
        <input type="hidden" name = "operation" value = "edit" >
    </p>
    <br>
    <button type = "submit">Edit</button>
</form>
</body>
</html>