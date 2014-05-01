<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Vitrine do Site</title>
	</head>

	<body>
		<div class="container">
			<section class="featured-products">
				<ul class="carousel-featured-products">
					<c:forEach items="${promoProducts}"  var="product" >
  						<li>
							<article>
								<a href="${pageContext.request.contextPath}/product/${product.id}">
									<header>
										<img src="${product.itemToDisplayOnShowcase.imageMain.promo}" alt="" class="product-image-promo">
									</header>
								</a>
								<div class="product-information-carousel">
									<span class="product-name-carousel"><a href="${pageContext.request.contextPath}/product/${product.id}"><strong>${product.name}</strong></a></span>
<%-- 									<span class="short-description">${product.shortDescription}</span> --%>
									<div class="product-price-box-carousel">
										<span class="price">de: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</span>
										<span>por: <span class="price-for"><strong>${product.itemToDisplayOnShowcase.formattedPriceFor}</strong></span></span>
									</div>
									<span class="installment">ou em até: ${product.itemToDisplayOnShowcase.lastInstallment}</span>
								</div>
							</article>
  						</li>
					</c:forEach>
				</ul>	
			</section>

			<section class="top-sellers-products">
				<h3>Produtos mais vendidos</h3>
				<ul class="carousel-top-sellers-products">
					<c:forEach items="${topSellersProducts}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="${pageContext.request.contextPath}/product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="${pageContext.request.contextPath}/product/${topSellerProduct.id}">${topSellerProduct.name}</a></span>
									<div class="product-price-box">
										<span class="price">De: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFrom}</span> | 
										<span class="price-sale">Por: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFor}</span>
									</div>
									<span class="installment">ou em ${topSellerProduct.itemToDisplayOnShowcase.lastInstallment}</span>
								</div>
							</article>
						</li>
					</c:forEach>
				</ul>
			</section>

			<section class="top-sellers-products">
				<h3>Produtos mais vendidos</h3>
				<ul class="carousel-top-sellers-products">
					<c:forEach items="${topSellersProductsFirstSection}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="${pageContext.request.contextPath}/product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="${pageContext.request.contextPath}/product/${topSellerProduct.id}">${topSellerProduct.name}</a></span>
									<div class="product-price-box">
										<span class="price">De: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFrom}</span> | 
										<span class="price-sale">Por: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFor}</span>
									</div>
									<span class="installment">ou em ${topSellerProduct.itemToDisplayOnShowcase.lastInstallment}</span>
								</div>
							</article>
						</li>
					</c:forEach>
				</ul>
			</section>

			<section class="top-sellers-products">
				<h3>Produtos mais vendidos</h3>
				<ul class="carousel-top-sellers-products">
					<c:forEach items="${topSellersProductsSecondSection}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="${pageContext.request.contextPath}/product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="${pageContext.request.contextPath}/product/${topSellerProduct.id}">${topSellerProduct.name}</a></span>
									<div class="product-price-box">
										<span class="price">De: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFrom}</span> | 
										<span class="price-sale">Por: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFor}</span>
									</div>
									<span class="installment">ou em ${topSellerProduct.itemToDisplayOnShowcase.lastInstallment}</span>
								</div>
							</article>
						</li>
					</c:forEach>
				</ul>
			</section>			
		</div>	
	</body>
</html>