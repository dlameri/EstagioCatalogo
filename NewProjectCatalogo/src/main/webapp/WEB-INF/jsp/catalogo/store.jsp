<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Vitrine do Site</title>
	</head>
	<body>
	
		<ul>
			<c:forEach items="${categories}"  var="category">
				<li><a href="">${category.name}</a></li>
				<ul>
					<c:forEach items="${category.subcategories}"  var="subcategory">
						<li><a href="">${subcategory.name}</a></li>
					</c:forEach>
				</ul>
			</c:forEach>
		</ul>
		
		<ul>
			<c:forEach items="${products}"  var="product">
				<c:forEach items="${product.items}" var="item">
					<li><a href="">${item.optionName}</a></li>
					<li>${item.priceFrom}</li>
					<li>${item.priceFor}</li>
				</c:forEach>
			</c:forEach>
		</ul>
		
	</body>
</html>