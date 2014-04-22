<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Vitrine do Site</title>
	</head>

	<body>
		<div class="container">
			<section class="featured-products">
				<ul class="bxslider">
					<c:forEach items="${topSellersProducts}"  var="product" >
  						<li>
							<article>
								<a href="./product/${product.id}">
									<header>
										<img src="${product.itemToDisplayOnShowcase.imageMain.promo}" alt="" class="product-image-promo">
									</header>
								</a>
								<div class="product-information-carousel">
									<span class="product-name-carousel"><a href="./product/${product.id}"><strong>${product.name}</strong></a></span>
									<span class="short-description">${product.shortDescription}</span>
									<div class="product-price-box-carousel">
										<span class="price">de: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</span>
										<span>por: <span class="price-for"><strong>${product.itemToDisplayOnShowcase.formattedPriceFor}</strong></span></span>
									<div>
									<span class="installment">ou em até: ${product.itemToDisplayOnShowcase.lastInstallment}</span>

								</div>
							</article>
  						</li>
					</c:forEach>
				</ul>	
			</section>

			<section class="top-sellers-product">
				<h3>Produtos mais vendidos</h3>
				<ul>
					<c:forEach items="${topSellersProducts}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="./product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="./product/${topSellerProduct.id}">${topSellerProduct.name}</a></span>
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
			<section class="top-sellers-product">
				<h3>Produtos mais vendidos</h3>
				<ul>
					<c:forEach items="${topSellersProductsFirstSection}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="./product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="./product/${topSellerProduct.id}">${topSellerProduct.name}</a></span>
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
			<section class="top-sellers-product">
				<h3>Produtos mais vendidos</h3>
				<ul>
					<c:forEach items="${topSellersProductsSecondSection}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="./product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="./product/${topSellerProduct.id}">${topSellerProduct.name}</a></span>
									<div class="product-price-box">
										<span class="price">De: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFrom}</span> | 
										<span class="price-sale">Por: ${topSellerProduct.itemToDisplayOnShowcase.formattedPriceFor}</span>
									</div>
									<span class="installment">ou em ${topSellerProduct.items[0].lastInstallment}</span>
								</div>
							</article>
						</li>
					</c:forEach>
				</ul>
			</section>
			
			<section class="top-sellers-product">
				<h3>Produtos EM CARROUSEL (TESTE)</h3>
					<ul class="item-show-carrousel">
						<c:forEach items="${topSellersProductsSecondSection}"  var="product" >
	  						<li>
	  							<section>
	  								<a href="./product/${product.id}">
	  									<img src="${product.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image">
		  									<article class="featured-products-info">
		  										<p class="product-name">${product.name}</p>
		  										<p class="item-short-description">${product.shortDescription}</p>
		  										<p class="price">Preço de: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</p>
		  										<p>por: <span class="item-price-for">${product.itemToDisplayOnShowcase.formattedPriceFor}</span></p>
		  								</article>
									</a>
								</section>
		  					</li>
						</c:forEach>
					</ul>
				</section>
			
		</div>	
	</body>
</html>