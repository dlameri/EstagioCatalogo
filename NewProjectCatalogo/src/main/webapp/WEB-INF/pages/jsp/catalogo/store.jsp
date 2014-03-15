<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Vitrine do Site</title>
	</head>
	<body>
	
		<ul>
			<c:forEach items="${categories}"  var="category">
				<li><a href="">${category.name}</a></li>	
			</c:forEach>
		</ul>
		
		<ul>
			<c:forEach items="${products}"  var="product">
				<c:forEach items="${product.items}" var="item">
					<li><a href="">${item.id}</a></li>	
					<li><a href="">${item.optionName}</a></li>
				</c:forEach>
			</c:forEach>
		</ul>
		
	</body>
</html>