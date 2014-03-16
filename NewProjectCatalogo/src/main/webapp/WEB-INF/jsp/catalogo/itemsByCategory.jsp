<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>${category.name}</title>
</head>
<body>

	
	<h2>${category.name}</h2>
	<ul>
		<c:forEach items="${category.subcategories}"  var="subcategory">
			<li><a href="../subcategory/${subcategory.id}">${subcategory.name}</a></li>
		</c:forEach>
	</ul>

	<ul>
		<c:forEach items="${products}"  var="product">
			<c:forEach items="${product.items}"  var="item">
				<li><a href="../item/${item.id}">${item.optionName}</a></li>
				<li>${item.formatedPriceFrom}</li>
				<li>${item.formatedPriceFor}</li>
			</c:forEach>
		</c:forEach>
	</ul>

</body>
</html>