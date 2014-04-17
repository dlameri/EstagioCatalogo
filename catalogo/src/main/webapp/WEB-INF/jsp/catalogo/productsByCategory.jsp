<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${category.name}</title>
	</head>
	<body>
		<h2>${category.name}</h2>
		<div class="container">
			<ul>
				<c:forEach items="${products}"  var="product">
					<li>${product.name}</li>
				</c:forEach>
			</ul>
		</div>
	</body>
</html>