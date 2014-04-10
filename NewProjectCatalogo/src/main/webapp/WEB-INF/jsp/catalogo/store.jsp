<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Vitrine do Site</title>
	</head>

	<body>
		<content tag="site-logo">
			<h1 class="logo"><a href="./">Ideais Electronics</a></h1>
		</content>
		<div id="id" class="container">
				<section class="featured-products">
					<ul class="bxslider">
  						<li>
  							<section>
  								<a href="">
  									<article>
  										<p class="product-name-carrousel">${products[0].name }</p>
  										<p class="short-description">${products[0].shortDescription}</p>
  										<p class="price-from">Preço de: ${products[0].items[0].formatedPriceFrom}</p>
  										<p>por: <span class="price-for">${products[0].items[0].formatedPriceFor}</span></p>
  									</article>
  									<img src="<c:url value="/resources/images/indisponivel.jpg"/>" alt="imagem"/>
								</a>
							</section>
  						</li>

  						<li>
  							<section>
  								<a href="">
  									<article>
  										<p class="product-name-carrousel">${products[0].name }</p>
  										<p class="short-description">${products[0].shortDescription}</p>
  										<p class="price-from">Preço de: ${products[0].items[0].formatedPriceFrom}</p>
  										<p>por: <span class="price-for">${products[0].items[0].formatedPriceFor}</span></p>
  									</article>
  									<img src="<c:url value="/resources/images/indisponivel.jpg"/>" alt="imagem"/>
								</a>
							</section>
  						</li>

  						<li>
  							<section>
  								<a href="">
  									<article>
  										<p class="product-name-carrousel">${products[0].name }</p>
  										<p class="short-description">${products[0].shortDescription}</p>
  										<p class="price-from">Preço de: ${products[0].items[0].formatedPriceFrom}</p>
  										<p>por: <span class="price-for">${products[0].items[0].formatedPriceFor}</span></p>
  									</article>
  									<img src="<c:url value="/resources/images/indisponivel.jpg"/>" alt="imagem"/>
								</a>
							</section>
  						</li>

  						<li>
  							<section>
  								<a href="">
  									<article>
  										<p class="product-name-carrousel">${products[0].name }</p>
  										<p class="short-description">${products[0].shortDescription}</p>
  										<p class="price-from">Preço de: ${products[0].items[0].formatedPriceFrom}</p>
  										<p>por: <span class="price-for">${products[0].items[0].formatedPriceFor}</span></p>
  									</article>
  									<img src="<c:url value="/resources/images/indisponivel.jpg"/>" alt="imagem"/>
								</a>
							</section>
  						</li>

  						<li>
  							<section>
  								<a href="">
  									<article>
  										<p class="product-name-carrousel">${products[0].name }</p>
  										<p class="short-description">${products[0].shortDescription}</p>
  										<p class="price-from">Preço de: ${products[0].items[0].formatedPriceFrom}</p>
  										<p>por: <span class="price-for">${products[0].items[0].formatedPriceFor}</span></p>
  									</article>
  									<img src="<c:url value="/resources/images/indisponivel.jpg"/>" alt="imagem"/>
								</a>
							</section>
  						</li>

  						<li>
  							<section>
  								<a href="">
  									<article>
  										<p class="product-name-carrousel">${products[0].name }</p>
  										<p class="short-description">${products[0].shortDescription}</p>
  										<p class="price-from">Preço de: ${products[0].items[0].formatedPriceFrom}</p>
  										<p>por: <span class="price-for">${products[0].items[0].formatedPriceFor}</span></p>
  									</article>
  									<img src="<c:url value="/resources/images/indisponivel.jpg"/>" alt="imagem"/>
								</a>
							</section>
  						</li>


					</ul>	
				</section>
			</div>

			<section class="top-sellers-product">
				<h3>Produtos mais vendidos</h3>
				<ul>
					<c:forEach items="${products}"  var="product">
						<li>
							<article>
								<header>
									<a href="./product/${product.id}"><img src="${product.itemToDisplayOnShowcase.urlImageMain}" alt="" class="product-main-image"></a>
								</header>
								<div class="product-information">
									<span class="product-name"><a href="./product/${product.id}">${product.name}</a></span>
									<div class="product-price-box">
										<span class="price">${product.itemToDisplayOnShowcase.formatedPriceFrom}</span> | 
										<span class="price-sale">${product.itemToDisplayOnShowcase.formatedPriceFor}</span>
									</div>
									<span class="installment">10x R$19,99 sem juros</span>
								</div>
							</article>
						</li>
					</c:forEach>
				</ul>
			</section>
			<section class="top-sellers-product">
				<h3>Produtos mais vendidos</h3>
				<ul>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
				</ul>
			</section>
			<section class="top-sellers-product">
				<h3>Produtos mais vendidos</h3>
				<ul>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
					<li>
						<article>
							<header>
								<a href=""><img src="" alt="" class="product-main-image"></a>
							</header>
							<div class="product-information">
								<span class="product-name"><a href="">Nome do produto</a></span>
								<div class="product-price-box">
									<span class="price">R$299,99</span> | 
									<span class="price-sale">R$199,99</span>
								</div>
								<span class="installment">10x R$19,99 sem juros</span>
							</div>
						</article>
					</li>
				</ul>
			</section>
		</div>
	</body>
</html>