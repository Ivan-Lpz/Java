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
	<div class="d-flex justify-content-around mt-4">
		<h1>Hello ${thisUser.userName }</h1>
		<a href="/logout">Logout</a>
	</div>
	<div class="d-flex justify-content-around">
		<h4>Books From Everyone's Shelves</h4>
		<a href="/books/new">+ Add a Book to My Shelf</a>
	</div>
	<table class="table table-dark table-striped mx-auto w-50 mt-5">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Title</th>
				<th scope="col">Author name</th>
				<th scope="col">Posted by</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allBooks}" var="book">
				<tr>
					<td>${book.id}</td>
					<td><a href="/show/book/${book.id}">${book.title }</a></td>
					<td>${book.author }</td>
					<td>${book.user.userName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>