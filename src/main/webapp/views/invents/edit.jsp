<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 19.07.2023
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<form method = "post" action = "/invent-controller">
    <p>
        Id <input name = "item_id" value = "<%=request.getParameter("item_id")%>">
    </p>
    <br>
    <p>
        Name <input name = "item_name" value = "<%=request.getParameter("item_name")%>">
    </p>
    <br>
    <p>
        Price <input name = "item_price" value = "<%=request.getParameter("item_price")%>">
    </p>
    <br>
    <p>
        Image <input name = "item_img" value = "<%=request.getParameter("item_img")%>">
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
