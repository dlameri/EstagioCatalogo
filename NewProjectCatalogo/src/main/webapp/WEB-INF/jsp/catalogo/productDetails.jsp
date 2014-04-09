<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${product.name}</title>
	</head>
	<body>
		<content tag="site-logo">
			<h1 class="logo"><a href="../">Ideais Electronics</a></h1>
		</content>
		
		
		<div class="container">
			<img alt="imagem do produto" src="${product.items[0].images[0].productUrl}">
			<div class="details">
				<h1>${product.shortDescription}</h1>
				
				<hr>
				<p><strong>De: ${product.items[0].formatedPriceFrom}</strong>
				<p><strong>Por: ${product.items[0].formatedPriceFor}</strong>
				<p>Desconto de: ${product.items[0].discount} % </p>
				
				
				<p><strong>Parcelas</strong></p>
				<ul class="installments">
					<c:forEach items="${product.items[0].installments}" var="entry">
			    		<li>${entry.key}x de R$ ${entry.value}</li>
					</c:forEach>
				</ul>
			</div>
			
			<br>
			<br>
			<br>
			
			<p>${product.longDescription}</p>
			
			<h1>Informações Técnicas</h1>

			<table>
				<tr>
					<td>Preço</td>
					<td><strong>${product.items[0].priceFor}</strong></td>
				</tr>
				<tr>
					<td>Garantia</td>
					<td>${product.warranty}</td>
				</tr>
				<tr>
					<td>Peso</td>
					<td>${product.weight}</td>
				</tr>
				<tr>
					<td>Marca</td>
					<td>${product.brand}</td>
				</tr>
				<tr>
					<td>Modelo</td>
					<td>${product.model}</td>
				</tr>
				<tr>
					<td>Altura</td>
					<td>${product.dimensions.height}</td>
				</tr>
				<tr>
					<td>Largura</td>
					<td>${product.dimensions.width}</td>
				</tr>
				<tr>
					<td>Comprimento</td>
					<td>${product.dimensions.depth}</td>
				</tr>
				
			</table>
			
			<c:forEach items="${product.items}" var="items">
				${items.sku} <br>
			</c:forEach>
		</div>
	</body>
</html>