<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 22.07.2023
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete item</title>
</head>
<body>
<form method = "post" action = "/invent-controller?">
  <p>
    Id <input type="text" name = "item_id" value = "<%=request.getParameter("item_id")%>" readonly>
  </p>
  <br>
  <p>
    Name <input type="text" name = "item_name" value = "<%=request.getParameter("item_name")%>" readonly>
  </p>
  <br>
  <p>
    <input  type="hidden" name = "operation" value = "delete" >
  </p>
  <br>
  <h2>Are you sure you want to remove this item?</h2>
  <button name="agree">Yes</button>
  <a href = "/views/invents/deleteCancel.jsp"><button>No</button></a>
</form>
</body>
</html>
