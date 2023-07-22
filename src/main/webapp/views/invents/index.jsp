<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 18.07.2023
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ page import="ru.andrew.test11.models.Invent" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<table>
<%
    PrintWriter pw = response.getWriter();
    List<Invent> inventList;
    inventList = (List<Invent>) request.getAttribute("inventList");
    for (Invent invent: inventList) {
        %>
    <tr>
    <td><%=invent.getItem_id()%></td>
        <td><%=invent.getItem_name()%></td>
        <td><a href = "/invent-controller?id=<%=invent.getItem_id()%>"> Card </a></td>
        <td><a href = "/views/invents/edit.jsp?item_id=<%=invent.getItem_id()%>&item_name=<%=invent.getItem_name()%>&item_price=<%=invent.getItem_price()%>&item_img=<%=invent.getItem_img()%>">Edit</a></td>
        <td><a href = "/views/invents/delete.jsp?item_id=<%=invent.getItem_id()%>&item_name=<%=invent.getItem_name()%>">Delete</a>
            <%}%>

</table>
<a href = "/views/invents/new.jsp"><button>Add</button></a>
</body>
</html>
