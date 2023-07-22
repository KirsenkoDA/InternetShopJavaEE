<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 14.07.2023
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<p>
    <%
        String initData=null;
        int userId = Integer.parseInt(request.getParameter("id"));
        String valueToImportId = request.getParameter("id");
        String valueToImportName = request.getParameter("user_name");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB", "postgres", "1976");

            PreparedStatement pstmt = conn.prepareStatement("SELECT user_name, birthdate FROM user_table WHERE id = ?");
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                initData = "INITIAL DATA: Name: " + rs.getString("user_name")+ " Birth Date: " + rs.getString("birthdate");
            }
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    %>
<%=initData%>
<h1>Edit User</h1>
<form method = "post" action = "/edit-user-servlet">

    <p>
        Id <input name = "id" value = "<%=valueToImportId%>" readonly>
    </p>
    <p>
        Name <input name = "user_name" value = "<%=valueToImportName%>">
    </p>
    <button type = "submit">Edit</button>
</form>
</body>
</html>
