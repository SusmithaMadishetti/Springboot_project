<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>User Info</title>
</head>
<body>
<div class="container">
<div class="row">
<table class="table table-dark">
<thead>
<tr>
<th scope="col">ID</th>

<th scope="col">name</th>
<th scope="col">email</th>

</tr>
</thead>
<tbody>
<c:forEach items="${users}" var="user">
<tr>
<td><c:out value="${user.id}"/></td>

<td><c:out value="${user.name}"/></td>
<td><c:out value="${user.email}"/></td>

</tr>
</c:forEach>
</tbody>
</table>
</div></div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html> 