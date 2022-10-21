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
	<h1>New Ninja</h1>

	<form:form modelAttribute="newNinja" action="/ninjas/submit" method="post">
		<div class="mb-3">
			First Name:
			<form:input path="first_name" />
			<br />
			<form:errors path="first_name" style="color: red" />

			Last Name:
			<form:input path="last_name" />
			<br />
			<form:errors path="last_name" style="color: red" />

			Age:
			<form:input path="age" />
			<br />
			<form:errors path="age" style="color: red" />
			
		
			<form:select path="dojo">
				<c:forEach items="${allDojos }" var ="dojo">
					<form:option value="${dojo.id}">
						${dojo.name}
					</form:option>
				</c:forEach>
			</form:select>
			
			

		</div>
		<button type="submit" class="btn btn-primary">Create Ninja</button>
	</form:form>
</body>
</html>