<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Carrinho de Itens</title>
	</head>
	<body>
		
		<c:forEach items="${shoppingCart.shoppingCartLines}" var="shoppingCartItens">
			<table>
				<thead>
					<tr>
						<td>Código</td>
						<td>Nome</td>
						<td>Descrição</td>
						<td>Quantidade</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${shoppingCartItens.product.id}</td>
						<td>${shoppingCartItens.product.name}</td>
					</tr>
				</tbody>
			</table>
		</c:forEach>

	</body>
</html>