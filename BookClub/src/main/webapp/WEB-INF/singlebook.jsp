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
		<h1>
			<c:out value="${book.title }"></c:out>
		</h1>
		<a href="/books">back to the shelves</a>
	</div>


	<p class="ms-5 fs-3 text mt-4">
		<c:out value="${book.user.userName}"></c:out>
		read
		<c:out value="${book.title }"></c:out>
		by
		<c:out value="${book.author }"></c:out>
	</p>
	<p class="ms-5 fs-4 text">
		Here are
		<c:out value="${book.user.userName}"></c:out>
		thoughts
	</p>

	<div class="w-25 ms-5">
		<hr />
	</div>

	<div class="w-25 ms-5">
		<c:out value="${book.thoughts }"></c:out>
	</div>
	
	<div class="w-25 ms-5">
		<hr />
	</div>

	<div class="d-flex"> 
	<c:if test="${user_id eq book.user.id}">
		<a href="/editpage/${id}"><button>edit</button></a>
		<form action="/delete/${book.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</c:if>
	</div>	
	
	<a href="/logout"><button>Logout</button></a>
	





</body>
</html>