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
	<h1>DOJOS</h1>

	<table class="table mx-auto w-50">
		<thead>
			<tr>
				<th scope="col">Dojo Name</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allDojos}" var="dojo">
				<tr>

					<td><a href="/allninjas/${dojo.id }">${dojo.name}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/dojos/new">Create Dojo</a>
	<a href="/ninjas/new">Create Ninja</a>
	<a href="/all/ninjas">All Ninjas</a>
</body>
</html>