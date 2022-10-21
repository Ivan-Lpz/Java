<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Syntactical Sugar</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>All Ninjas</h1>

	<table class="table mx-auto w-50">
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
				<th scope="col">Dojo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allNinjas}" var="ninja">
				<tr>
					<td>${ninja.first_name}</td>
					<td>${ninja.last_name}</td>
					<td>${ninja.age}</td>
					<td><a href="/allninjas/${dojo.id }">${ninja.dojo.name }</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/dojos/all">Back to Dojos</a>
</body>
</html>