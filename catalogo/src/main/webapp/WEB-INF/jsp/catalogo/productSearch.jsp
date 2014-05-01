<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title> Ideais Eletronics</title>
	</head>
	<body>
		<div class="container">
			<section class="product">
				<h3>Produtos</h3>
				<ul class="paginatedProducts">
					<c:forEach items="${products}"  var="product">
						<li>
							<article>
								<header>
									<a href="${pageContext.request.contextPath}/product/${product.id}"><img src="${product.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="${pageContext.request.contextPath}/product/${product.id}">${product.name}</a></span>
									<div class="product-price-box">
										<span class="price">De: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</span>
										<span class="price-sale">Por: ${product.itemToDisplayOnShowcase.formattedPriceFor}</span>
									</div>
									<span class="installment">ou em ${product.itemToDisplayOnShowcase.lastInstallment}</span>
								</div>
							</article>
						</li>
					</c:forEach>
				</ul>
			</section>
		</div>
	</body>
</html>