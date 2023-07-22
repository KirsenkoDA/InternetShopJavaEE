<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Internet Shop</title>
</head>
<body>
<div name = "header"></div>
<p align="right">
    <%=session.getAttribute("user_id")%>
  <a href = "static/form.html"><button>Sign Up</button></a>
  <a href = "static/SignInForm.html"><button>Sign In</button></a>
</p>
<p align = "left">
    <h1><%= "Internet Shop" %></h1>
</p>
</div>
<br/>
<a href="/controllers/userControllers/user-servlet">User List</a>
<br>
<a href="/invent-controller">Invent List</a>
</body>
</html>