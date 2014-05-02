<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${category.name}</title>
		<content tag="pagination-script">
			<script type="text/javascript" src="<c:url value="/resources/js/pagination.js"/>"></script>
		</content>
	</head>
	<body>
		<div class="container">
			<nav class="side-nav">
				<span class="category-title">${category.name}com nome muito grande</span>
				<ul class="subcategory-nav">
					<c:forEach items="${category.subcategories}" var="subcategory">
						<li class="subcategory-item-nav"><a href="${pageContext.request.contextPath}/subcategory/${subcategory.id}/product">${subcategory.name}</a></li>
					</c:forEach>
				</ul>
			</nav>
			<section class="products-by-category">
				<ul class="paginatedProducts">
					<!-- <c:forEach items="${products}"  var="product">
						<li>
							<article>
								<header>
									<a href="${pageContext.request.contextPath}/product/${product.id}"><img src="${product.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="${pageContext.request.contextPath}/${product.id}">${product.name}</a></span>
									<div class="product-price-box">
										<span class="price">De: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</span> | 
										<span class="price-sale">Por: ${product.itemToDisplayOnShowcase.formattedPriceFor}</span>
									</div>
									<span class="installment">ou em ${product.itemToDisplayOnShowcase.lastInstallment}</span>
								</div>
							</article>
						</li>
					</c:forEach> -->
				</ul>
				<div id="pagination"></div>
				<input type="hidden" id="categoryId" value="${category.id}">
				<input type="hidden" id="context" value="${pageContext.request.contextPath}">
				<input type="hidden" id="count" value="${count}">
			</section>
		</div>
	</body>
</html>