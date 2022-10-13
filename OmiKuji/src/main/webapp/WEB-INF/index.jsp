<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Form Page</title>
</head>
<body>
	<div class="d-flex justify-content-center">
		<h1>Send an Omikuji!</h1>
	</div>

	<hr />
	<form class="mx-auto w-50" action="/submitpost" method="POST">
		<select name="num">
			<c:forEach var="nums" items="${arrayNum}">
    		<option><c:out value="${nums}"/></option>
    		</c:forEach>
		</select>
		<div class="mb-3">
			<label for="city" class="form-label">Enter the name of any city.</label>
			<input type="text" class="form-control" name="city">
		</div>
		<div class="mb-3">
			<label for="person" class="form-label">Enter the name of any real person</label>
			<input type="text" class="form-control" name="person">
		</div>
		<div class="mb-3">
			<label for="hobby" class="form-label">Enter professional endeavor or hobby.</label>
			<input type="text" class="form-control" name="hobby">
		</div>
		<div class="mb-3">
			<label for="thing" class="form-label">Enter any type of living thing.</label>
			<input type="text" class="form-control" name="thing">
		</div>
		<div class="mb-3">
			<label for="comment" class="form-label">Say something nice to someone.</label>
			<input type="text" class="form-control" name="comment">
		</div>
		Send and show a friend <br />
		<a href="/submitpost"><button type="submit" class="btn btn-primary">Send</button></a>    
	</form>
</body>
</html>