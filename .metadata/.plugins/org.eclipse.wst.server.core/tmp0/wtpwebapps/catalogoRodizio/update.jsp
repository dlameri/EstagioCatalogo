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
<script type="text/javascript" src="./js/update.js"></script>

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
			<li><a href="home.jsp" accesskey="1" title="">Sistema de Cadastro</a></li>
			<li class="current_page_item"><a accesskey="1" title="">Produtos Cadastrados</a></li>
		</ul>
	</div>
	<div id="three-column" class="container">
		<div id="tbox4"> <span class="icon icon-cogs"></span>
			<div class="title">
				<h2>Produtos em Estoque</h2>
			</div>
		</div>
		<div id="tbox4">
			<h3><s:property value="message"/></h3>
				<table>
					<thead>
						<tr>
							<td>Nome</td>
							<td>Descrição</td>
							<td>Ficha Técnica</td>
							<td>Categoria</td>
							<td>Qtd. Estoque</td>
							<td>De:</td>
							<td>Por:</td>
							<td>Ranking</td>
							<td>Imagens</td>
							<td></td>
						</tr>
					</thead>
			
					<tbody>
						<s:iterator value="listProducts" var="product">
							<tr>
								<td><s:property value="name"/> </td>
								<td><s:property value="description"/> </td>
								<td><s:property value="card"/> </td>
								<td><s:property value="category.name"/> </td>
								<td><s:property value="stock"/> </td>
								<td><s:property value="priceFrom"/> </td>
								<td><s:property value="priceFor"/> </td>
								<td><s:property value="ranking"/> </td>
								<td>
									<figure>
										<img alt="imagem cadastrada do produto" src="${image.path}" id="image"/>
									</figure>
								</td>								
								
															
								<td>
									<s:url var="urldeletar" action="deletar">
										<s:param name="id">
											<s:property value="id"/>
										</s:param>
									</s:url>
									<s:a href="%{urldeletar}" name="btn-remover">Remover</s:a>
								</td>
								
								<td>
									<s:url var="urleditar" action="findById">
										<s:param name="id">
											<s:property value="id"/>
										</s:param>
									</s:url>
									<s:a href="%{urleditar}" name="btn-editar">Editar</s:a>
								</td>
								
							</tr>
						</s:iterator>
					</tbody>
			</table>	
		</div>
	</div>
</div>
<div id="copyright">
	<p>Copyright (c) 2013 Uila & JotaJota Enterprise All rights reserved. | Design by Uila & Jota Jota Enterprises.</p>
</div>
</body>
</html>