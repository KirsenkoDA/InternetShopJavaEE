<%--
  Created by IntelliJ IDEA.
  User: kda
  Date: 18.07.2023
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Internet Shop</title>
</head>
<body>
<table border = "1">
  <tr><th>Id</th><th>Name</th><th>Price</th><th>Image</th></tr>
  <c:forEach var="item" items="${inventList}">
    <tr>
      <td>${item.item_id}</td>
      <td>${item.item_name}</td>
      <td>${item.item_price}</td>
      <td><img height="50" width="50" src="https://cdn.rbt.ru/images/gen/item_image/image/9728/24/972733_r83.jpg"></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
