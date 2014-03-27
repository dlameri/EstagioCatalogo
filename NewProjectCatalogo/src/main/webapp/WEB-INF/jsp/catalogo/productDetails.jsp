<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>${product.name}</title>
</head>
<body>
	<h1>${product.shortDescription}</h1>
	
			<img alt="imagem do produto" src="${product.items[0].images[0].productUrl}">
	 
	<hr>
	<p><strong>De: ${product.items[0].formatedPriceFrom}</strong></p>
	<p><strong>Por: ${product.items[0].formatedPriceFor}</strong></p>
	<p>Desconto de: ${product.items[0].discount} % </p>
	<p>Parcelas</p>
		<c:forEach items="${product.items[0].installments}" var="entry">
    		${entry.key}x de R$ ${entry.value}<br>
		</c:forEach>
	
	
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

</body>
</html>