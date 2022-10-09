<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruit Loops</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Fruit Store</h1>
	<%-- <c:out value="${bob}"/> --%>
 <c:out value="${arrayFruits}"/> 
	<%-- <c:out value="${fruit.name} ${fruit.price}"/> --%>

	<hr />

	<c:forEach items="${arrayFruits}" var="fruit">
		<li>This is <c:out value="${fruit.name} ${fruit.price}"></c:out>
		</li>

	</c:forEach>

	<hr />

	<table class="table table-dark table-striped w-50 mx-auto">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${arrayFruits}" var="fruit">
				<tr>
					<td>
						${fruit.name} 
						
					</td>
					<td>
						${fruit.price}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>