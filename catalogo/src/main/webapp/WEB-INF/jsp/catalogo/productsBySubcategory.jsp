<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${subcategory.name}</title>
	</head>
	<body>
		
		<div class="container">
			<h2>${subcategory.name}</h2>
			<ul>
				<c:forEach items="${products}"  var="product">
					<li>${product.name}</li>
				</c:forEach>
			</ul>
		</div>

	</body>
</html>