<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
		<div id="tbox4">
			<c:choose>
				<c:when test="${message != null }"><h1>${message}</h1></c:when>
				
				<c:otherwise><h1>Algo inesperado aconteceu...</h1></c:otherwise>
			</c:choose>
		</div>
	</div>	
</div>
<div id="copyright">
	<p>Copyright (c) 2013 Uila & JotaJota Enterprise All rights reserved. | Design by Uila & Jota Jota Enterprises.</p>
</div>
</body>
</html>