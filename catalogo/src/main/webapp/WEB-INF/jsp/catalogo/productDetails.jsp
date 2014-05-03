<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.jsp.PageContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>${product.name}</title>
	</head>
	<body>
		<div class="container">
			<div class="container-photo">
				<ul class="photo-product-details">
					<c:forEach items="${product.itemToDisplayOnShowcase.images}"  var="image" >
	 					<li><img alt="imagem do produto" src="${image.productUrl}" /></li>
	 				</c:forEach>
				</ul>
			</div>
			
		
			<div class="details-product">
				<h1>${product.shortDescription}</h1>
				<hr>
				<div class="price-info-box">
					<p><strong class="priceFrom">De: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</strong>
					<p><strong class="priceFor">Por: ${product.itemToDisplayOnShowcase.formattedPriceFor} </strong>
					<p class="discount">( desconto de: ${product.itemToDisplayOnShowcase.discount} % )</p>
					<span class="installment2">${product.itemToDisplayOnShowcase.lastInstallment} sem juros</span>
					
					<ul class="see-all-installments">
						<li> ver parcelas </li>
							<ul class="installments">
								<li> <strong> <p>Parcelas:</p> </strong> </li>
									<c:forEach items="${product.itemToDisplayOnShowcase.installments}" var="entry">
							    		<li>${entry.number}x de R$ ${entry.value}</li>
									</c:forEach>
							</ul>
					</ul>
				</div>
				<form action="${pageContext.request.contextPath}/shoppingCart/addItem" method="post">
					<input type="hidden" name="itemId" value="${product.itemToDisplayOnShowcase.id}">
					<input type="submit" class="BuyButton" value="Comprar">
				</form>
			</div>
			<div class="content">
				${product.longDescription}
				
				<h1>Informações Técnicas</h1>

				<table>
					<tr>
						<td>Preço</td>
						<td><strong>${product.itemToDisplayOnShowcase.priceFor}</strong></td>
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
			</div>
		</div>
	</body>
</html>