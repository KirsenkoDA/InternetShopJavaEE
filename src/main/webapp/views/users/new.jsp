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
    <title>Add users</title>
</head>
<body>
<h1>Add new user</h1>
<form method = "post" action = "/users-controller">
    <p>
        Id <input name = "id">
    </p>
    <br>
    <p>
        Name <input name = "user_name">
    </p>
    <br>
    <p>
        Birthdate <input name = "birthdate">
    </p>
    <br>
    <p>
        <input  type="hidden" name = "operation" value = "add" >
    </p>
    <button type = "submit">Create</button>
</form>
</body>
</html>
