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
	<h1>New Dojo</h1>	
	
	<c:forEach items="${allDojos}" var="dojo">
		${dojo.name}:
	</c:forEach>
	
	
	
	<form:form modelAttribute="dojo" action="/dojos/submit" method="post">
  <div class="mb-3">
  	name: <form:input path="name" /> <br />
  	<form:errors path="name" style="color: red" />
  	
  </div>
  <button type="submit" class="btn btn-primary">Create Dojo</button>
</form:form>
<a href="/dojos/all">View All Dojos</a>

	<%-- <form:form action="/expenses" method="post" modelAttribute="newExpense"
		class="w-50 mx-auto">
		<div class="mb-3">
			<form:label path="name">Expense Name:</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</div>
		<input type="submit" value="Submit" />
	</form:form> --%>
	
	
	
</body>
</html>