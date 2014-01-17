<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Justifiable 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20130801

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800|Open+Sans+Condensed:300,700" rel="stylesheet" />
<link href="./css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="./css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="./js/catalogo.js"></script>

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="logo" class="container">
	<h1><img src="./images/logobolinha.png"><!--<span class="icon icon-lock icon-size"></span>--><a href="#"><span>Estágio Ideais</span></a></h1>
	<p>Sistema de Controle e Administração de Estoque</p>
</div>
<div id="wrapper" class="container">
	<div id="menu" class="container">
		<ul>
			<li class="current_page_item"><a href="home.jsp" accesskey="1" title="">Sistema de Cadastro</a></li>
			<li><s:a accesskey="1" title="" action="listar">Produtos Cadastrados</s:a></li>
		</ul>
	</div>
	<div id="three-column" class="container">
		<div id="tbox2"> <span class="icon icon-wrench"></span>
			<c:choose>
				<c:when test="${ product.id == null }">
					<div class="title">
						<h2>Cadastro de Produtos</h2>
					</div>
					<p>Pagina criada para administrar o cadastro de produtos. Aqui será possí­vel cadastrar os produtos em nosso sistema de administração e controle de estoque.</p>
				</c:when>
				<c:otherwise>
					<div class="title">
						<h2>Edição de Produtos</h2>
					</div>
					<p>Pagina criada para administrar a edição de produtos. Aqui será possí­vel alterar os produtos em nosso sistema de administração e controle de estoque.</p> 
				</c:otherwise>
			</c:choose>
		</div>
		<div id="tbox3">
				 <c:choose>
					<c:when test="${ product.id == null }">
						<s:form action="cadastrar">
							 <s:label value="Nome"/><s:textfield name ="product.name" id="inputz"/>
							 <s:label value="Categoria"/><s:textfield name ="product.category.name" id="inputz"/>
							 <s:label value="Quantidade em Estoque"/><s:textfield name ="product.stock" id="inputz"/>
							 <s:label value="Preço De:"/><s:textfield name ="product.priceFrom" id="inputz"/>
							 <s:label value="Preço Por:"/><s:textfield name ="product.priceFor" id="inputz"/>
							 <s:label value="Imagens "/><s:textfield name ="product.image.path" id="inputz"/>
							 <s:label value="Ficha Técnica"/><s:textarea name ="product.card" id="inputz"/>
							 <s:label value="Descrição"/><s:textarea name ="product.description" id="inputz"/>
							 <s:submit value="Cadastrar Produto no Sistema" />
						</s:form>		
					</c:when>
					<c:otherwise>
						<s:form action="alterar">
							 <s:textfield type="hidden" name="product.id"/>
							 <s:textfield type="hidden" name="product.image.id"/>
							 
							 <s:label value="Nome"/><s:textfield name ="product.name" id="inputz"/>
							 <s:label value="Categoria"/><s:textfield name ="product.category.name" id="inputz"/>
							 <s:label value="Quantidade em Estoque"/><s:textfield name ="product.stock" id="inputz"/>
							 <s:label value="Preço De:"/><s:textfield name ="product.priceFrom" id="inputz"/>
							 <s:label value="Preço Por:"/><s:textfield name ="product.priceFor" id="inputz"/>
							 <s:label value="Imagens "/><s:textfield name ="product.image.path" id="inputz"/>
							 <s:label value="Ficha Técnica"/><s:textarea name ="product.card" id="inputz"/>
							 <s:label value="Descrição"/><s:textarea name ="product.description" id="inputz"/>	
							<s:submit value="Alterar Produto no Sistema">
							</s:submit> 
						</s:form>	
					</c:otherwise>
				</c:choose>
		</div>
	</div>	
</div>
<div id="copyright">
	<p>Copyright (c) 2013 Uila & JotaJota Enterprise All rights reserved. | Design by Uila & Jota Jota Enterprises.</p>
</div>
</body>
</html>