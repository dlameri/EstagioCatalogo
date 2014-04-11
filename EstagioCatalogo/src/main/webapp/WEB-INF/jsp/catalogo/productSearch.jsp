<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Vitrine do Site</title>
	</head>

	<body>
		<div id="id" class="container">
			<section class="top-sellers-product">
				<h3>Produtos</h3>
				<ul>
					<c:forEach items="${product}"  var="product">
						<li>
							<article>
								<header>
									<a href="./${product.id}"><img src="${product.itemToDisplayOnShowcase.urlImageMain}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="./${product.id}">${product.name}</a></span>
									<div class="product-price-box">
										<span class="price">${product.itemToDisplayOnShowcase.formatedPriceFrom}</span> | 
										<span class="price-sale">${product.itemToDisplayOnShowcase.formatedPriceFor}</span>
									</div>
									
								</div>
							</article>
						</li>
					</c:forEach>
				</ul>
			</section>
		</div>
	</body>
</html>