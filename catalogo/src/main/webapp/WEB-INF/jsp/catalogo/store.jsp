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
					<c:forEach items="${products}"  var="product" begin="0" end="5">
  						<li>
  							<section>
  								<a href="./product/${product.id}">
  									<article>
  										<p class="product-name-carrousel">${product.name}</p>
  										<p class="short-description">${product.shortDescription}</p>
  										<p class="price-from">Preço de: ${product.items[0].formattedPriceFrom}</p>
  										<p>por: <span class="price-for">${product.items[0].formattedPriceFor}</span></p>
  										<p>ou em até: ${product.items[0].lastInstallment}</p>
  									</article>
  									<img src="${product.itemToDisplayOnShowcase.imageMain}" alt="" class="product-main-image">
								</a>
							</section>
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
									<a href="./product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain}" alt="" class="product-main-image"></a>
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
				<h3>Produtos mais vendidos</h3>
				<ul>
					<c:forEach items="${topSellersProductsFirstSection}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="./product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain}" alt="" class="product-main-image"></a>
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
				<h3>Produtos mais vendidos</h3>
				<ul>
					<c:forEach items="${topSellersProductsSecondSection}"  var="topSellerProduct">
						<li>
							<article>
								<header>
									<a href="./product/${topSellerProduct.id}"><img src="${topSellerProduct.itemToDisplayOnShowcase.imageMain}" alt="" class="product-main-image"></a>
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
						<c:forEach items="${products}"  var="product" begin="0" end="5">
	  						<li>
	  							<section>
	  								<a href="./product/${product.id}">
	  									<img src="${product.itemToDisplayOnShowcase.urlImageMain}" alt="" class="product-main-image">
		  									<article class="featured-products-info">
		  										<p class="product-name">${product.name}</p>
		  										<p class="item-short-description">${product.shortDescription}</p>
		  										<p class="item-price-from">Preço de: ${product.items[0].formatedPriceFrom}</p>
		  										<p>por: <span class="item-price-for">${product.items[0].formatedPriceFor}</span></p>
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