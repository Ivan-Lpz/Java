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
		<h1>Expense Details</h1>
		<a href="/">Go back</a>

	</div>
	<div class="w-50 mx-auto mt-5 fs-3 text">
		Expense Name: <c:out value="${expense.name}"></c:out> <br />
		Expense Description: <c:out value="${expense.description}"></c:out><br />
		Vendor: <c:out value="${expense.vendor}"></c:out> <br />
		Amount Spent: $<c:out value="${expense.amount}"></c:out>
	</div>
</body>
</html>








