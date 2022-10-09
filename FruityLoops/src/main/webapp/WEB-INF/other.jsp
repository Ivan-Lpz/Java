<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Other</title>
</head>
<body>
	<p>Hello</p>
	<p>
		<c:out value="${first}" />
	</p>
	<p>
		<c:out value="${last}" />
	</p>
	<p>
		<c:out value="${email}" />
	</p>
	<p>
		<c:out value="${age}" />
	</p>
</body>
</html>



