<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>${subcategory.name}</title>
</head>
<body>

	
	<h2>${subcategory.name}</h2>
	
	<ul>
		<c:forEach items="${products}"  var="product">
			<li><a href="../../product/${product.id}">${product.name}</a></li>
			<!-- <li>${item.formatedPriceFrom}</li>
			<li>${item.formatedPriceFor}</li> -->
		</c:forEach>
	</ul>

</body>
</html>