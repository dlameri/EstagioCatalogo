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
				<span class="category-title">${category.name}</span>
				<ul class="subcategory-nav">
					<c:forEach items="${category.subcategories}" var="subcategory">
						<li class="subcategory-item-nav" data-subcategory-id="${subcategory.id}">
							<a href="#">${subcategory.name}</a>
						</li>
					</c:forEach>
				</ul>
			</nav>
			<section class="products">
				<ul class="paginatedProducts">
					
				</ul>
				<div class="loading"></div>
				<div class="pagination">
					<input type="hidden" id="page" value="categorySubcategoryProducts">
					<input type="hidden" id="categoryId" value="${category.id}">
					<input type="hidden" id="context" value="${pageContext.request.contextPath}">
					<input type="hidden" id="categoryProductsCounted" value="${categoryProductsCounted}">
				</div>
			</section>
		</div>
	</body>
</html>