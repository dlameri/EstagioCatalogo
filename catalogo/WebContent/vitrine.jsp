<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">

	<head>
	    <title>Loja Virtual</title>
	    <link rel="stylesheet" type="text/css" href="css/style.css">
	    <meta charset = "utf-8">
	</head>

<body>
	<div id="container">
		<div id="header">
			<div id="logotipo">
				<a href="showcase.action"><img id="logo" src="./images/icons/logo.png" alt="home"></a>
				<h1>
					IDEAIS <br> ELETRONICS
				</h1>
			</div>


			<div id="navegation">
				<h6>atendimento | meus produtos | minha conta</h6>
				<input type="text" value="Pesquisar" size="48"><input
					id="search_icon" type="image" alt="search submit"
					src="./images/icons/search_icon.png" height="22" width="22">
			</div>


			<img id="cart" src="./images/icons/cart.png" alt="cart">
		</div>

		<div id="menu">
			<ul>
				<c:forEach items="${listCategories}" var="category">
					<li><a href="showProductsByCategory.action?idCategory=${category.id}">${category.name}</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="contents">
			<table>
				<tbody>
					<tr>
						<c:forEach items="${listProducts}" var="product">
							<td>
								<figure>
									<a href="showProductDetails.action"><img alt="${product.item.shortDescription}" src="${product.imageMain.showcaseUrl}"></a>
									<figcaption><a href="showProductDetails.action">${product.item.name}</a></figcaption>
								</figure>
							</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>