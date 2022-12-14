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
	<h1>LOGIN AND REGISTRATION</h1>
	<!-- REGISTER A NEW USER -->
	<form:form action="/register" method="post" modelAttribute="newUser"
		class="mx-auto w-50 mt-5">
		<h2>Register</h2>

		<div class="mb-3">
			<label>User Name:</label>
			<form:input path="userName" class="form-control" />
			<form:errors path="userName" class="text-danger" />
		</div>
		<div class="mb-3">
			<label>Email:</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>
		<div class="mb-3">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<div class="mb-3">
			<label>Confirm Password:</label>
			<form:password path="confirm" class="form-control" />
			<form:errors path="confirm" class="text-danger" />
		</div>
		<input type="submit" value="Register" class="btn btn-primary" />
	</form:form>


	<!-- LOGIN A USER AS WELL AS VALIDATE WITH modelAttribute "newLogin" -->

	<form:form class="mx-auto w-50 mt-5" action="/login" method="post" modelAttribute="newLogin">
		<div class="mb-3">
			<label>Email:</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" class="text-danger" />
		</div>
		<div class="mb-3">
			<label>Password:</label>
			<form:password path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<input type="submit" value="Login" class="btn btn-success" />
	</form:form>
</body>
</html>