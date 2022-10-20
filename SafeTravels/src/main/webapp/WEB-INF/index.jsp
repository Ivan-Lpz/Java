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
	<h1 class="mx-auto w-75 mt-4">Safe Travels</h1>
	<table class="table table-success table-striped mx-auto w-75">
		<thead>
			<tr>
				<th scope="col">Expense</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allExpenses }" var="expense">
				<tr>
					<td><a href="/show/${expense.id}">${expense.name }</a></td>
					<td>${expense.vendor }</td>
					<td>$ ${expense.amount }</td>
					<td><a href="/edit/${expense.id}">Edit</a>
						<form action="/delete/${expense.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2 class="mx-auto w-50">Add an expense</h2>
	<form:form action="/expenses" method="post" modelAttribute="newExpense"
		class="w-50 mx-auto">
		<div class="mb-3">
			<form:label path="name">Expense Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</div>
		<div class="mb-3">
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor" />
			<form:input path="vendor" />
		</div>
		<div class="mb-3">
			<form:label path="amount">Amount:</form:label>
			<form:errors path="amount" />
			<form:input type="number" path="amount" />
		</div>
		<div class="mb-3">
			<form:label path="description">Description:</form:label>
			<form:errors path="description" />
			<form:input path="description" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>