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
	<div class="d-flex justify-content-around mt-5">
		<h1>Change your Entry</h1>
		<a href="/books">Back to the shelves</a>
	</div>

	<form:form action="/submit/edit/${newBook.id}" method="put" modelAttribute="newBook" class="w-50 mx-auto">
	<!-- <input type="hidden" name="_method" value="put"> -->
	<form:errors path="*" class="text-danger" />
		
		<form:hidden path="user" />
		<div class="mb-3">
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
		</div>
		<div class="mb-3">
			<form:label path="author">Author:</form:label>
			<form:input path="author" />
		</div>
		<div class="mb-3">
			<form:label path="thoughts">My thoughts:</form:label>
			<form:input path="thoughts" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>