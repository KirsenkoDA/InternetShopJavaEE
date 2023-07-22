<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 19.07.2023
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add item</title>
</head>
<body>
<h1>Add new item</h1>
<form method = "post" action = "/invent-controller">
    <p>
        Id <input name = "item_id">
    </p>
    <br>
    <p>
        Name <input name = "item_name">
    </p>
    <br>
    <p>
        Price <input name = "item_price">
    </p>
    <br>
    <p>
        Image <input name = "item_img">
    </p>
    <br>
    <button type = "submit">Create</button>
</form>
</body>
</html>
