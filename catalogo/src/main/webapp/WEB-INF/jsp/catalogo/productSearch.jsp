<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<content tag="pagination-script">
			<script type="text/javascript" src="<c:url value="/resources/js/pagination-search.js"/>"></script>
		</content>
	</head>
	<body>
		<div class="container">
			<section class="productsSearch">
				<h2>Resultados de busca para "${textToSearch}"</h2>
				<ul class="paginatedProducts">
					
				</ul>
				<div class="loading"></div>
				<div class="pagination">
					<input type="hidden" id="textToSearch" value="${textToSearch}">
					<input type="hidden" id="context" value="${pageContext.request.contextPath}">
				</div>
			</section>
		</div>
	</body>
</html>