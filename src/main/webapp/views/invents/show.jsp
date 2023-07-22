<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 19.07.2023
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invent Card</title>
</head>
<body>

<%@ page import="ru.andrew.test11.models.Invent" %>
<%@ page import="java.util.*" %>

<h1>Item Card</h1>

<table>
        <%Invent invent = (Invent) request.getAttribute("invent");%>
    <tr>
        <td>ID</td><td><%=invent.getItem_id()%></td>
    </tr>
            <tr>
                <td>Name</td><td><%=invent.getItem_name()%></td>
            </tr>
</body>
</html>
