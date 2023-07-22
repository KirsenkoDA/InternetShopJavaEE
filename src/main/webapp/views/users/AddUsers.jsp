<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 18.07.2023
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<h1>Create new user</h1>
<form method = "post" action = "/add-user-servlet">
  <p>
    Id <input name = "id">
  </p>
  <br>
  <p>
    Name <input name = "user_name">
  </p>
  <br>
  <p>
    Birth Date<input name = "birthdate">
  </p>
  <br>
  <button type = "submit">Create</button>
</form>
</body>
</html>
