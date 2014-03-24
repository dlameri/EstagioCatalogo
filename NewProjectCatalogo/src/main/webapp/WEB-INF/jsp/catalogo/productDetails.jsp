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
	<img alt="imagem do produto" src="${image.productUrl}">

	<hr>
	<p>${product.longDescription}</p>
	
	<h1>Informações Técnicas</h1>

	<table>
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
			<td>${dimensions.height}</td>
		</tr>
		<tr>
			<td>Largura</td>
			<td>${dimensions.width}</td>
		</tr>
		<tr>
			<td>Comprimento</td>
			<td>${dimensions.depth}</td>
		</tr>
		
	</table>

</body>
</html>