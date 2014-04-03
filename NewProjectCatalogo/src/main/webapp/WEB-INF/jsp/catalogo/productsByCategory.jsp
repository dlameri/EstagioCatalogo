<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${category.name}</title>
	</head>
	<body>
		<content tag="site-logo">
			<h1 class="logo"><a href="./../">Ideais Electronics</a></h1>
		</content>
		<content tag="header-nav">
			<nav id="main-nav" class="main-menu">
				<ul class="menu">
					<c:forEach items="${categories}"  var="category">
						<li class="menu-item"><a href="./../category/${category.id}">${category.name}</a>
							<ul class="sub-menu">
								<c:forEach items="${category.subcategories}"  var="subcategory">
									<li class="submenu-item"><a href="./../category/subcategory/${subcategory.id}">${subcategory.name}</a></li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</nav>
		</content>
	
		<h2>${category.name}</h2>
		<ul>
			<c:forEach items="${category.subcategories}"  var="subcategory">
				<li><a href="../category/subcategory/${subcategory.id}">${subcategory.name}</a></li>
			</c:forEach>
		</ul>
	
		<ul>
			<c:forEach items="${products}"  var="product">
				<li><a href="../product/${product.id}">${product.name}</a></li>
				<!-- <li>${item.formatedPriceFrom}</li>
				<li>${item.formatedPriceFor}</li> -->
			</c:forEach>
		</ul>

	</body>
</html>