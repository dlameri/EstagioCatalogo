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
				<li><a href="./category/${category.id}">${category.name}</a></li>
				<ul>
					<c:forEach items="${category.subcategories}"  var="subcategory">
						<li><a href="./category/subcategory/${subcategory.id}">${subcategory.name}</a></li>
					</c:forEach>
				</ul>
			</c:forEach>
		</ul>
		
		<ul>
			<c:forEach items="${products}"  var="product">
				<li></li>
				<img src="${product.itemToDisplayOnShowcase.urlImageMain}">
				<li><a href="./product/${product.id}">${product.name}</a></li>
				<li>${product.itemToDisplayOnShowcase.formatedPriceFrom}</li>
				<li>${product.itemToDisplayOnShowcase.formatedPriceFor}</li>
			</c:forEach>
		</ul>
		
	</body>
</html>