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
  <title>Delete user</title>
</head>
<body>
<form method = "post" action = "/users-controller">
  <p>
    Id <input type="text" name = "id" value = "<%=request.getParameter("id")%>" readonly>
  </p>
  <br>
  <p>
    Name <input type="text" name = "user_name" value = "<%=request.getParameter("user_name")%>" readonly>
  </p>
  <br>
  <p>
    <input  type="hidden" name = "operation" value = "delete" >
  </p>
  <br>
  <h2>Are you sure you want to remove this item?</h2>
  <button name="agree">Yes</button>
  <a href = "/views/users/deleteCancel.jsp">No</a>
</form>
</body>
</html>
