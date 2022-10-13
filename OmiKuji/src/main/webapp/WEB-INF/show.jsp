<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<meta charset="UTF-8">
<title>Show Page</title>
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	<div class="mx-auto bg-primary w-50">
		In <c:out value="${num}"/> years, you will live in <c:out value="${city}"/>
		with <c:out value="${person}"/> as your roomate, <c:out value="${hobby}"/>
		for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck.
		Also, <c:out value="${comment}"/>
	</div>
	<a href="/omikuji">Go Back</a>
</body>
</html>