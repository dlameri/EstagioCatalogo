<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><decorator:title default="Ideais Electronics"/></title>

	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

	<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>

	<header id="main-header">
		<div class="container-header">
			<decorator:getProperty property="page.site-logo"/>
			<div id="search-area">
				<div class="search-box">
					<input type="text" id="input-search-text">
					<input type="submit" value="Pesquisar" id="input-search-submit" class="search-icon">
				</div>
			</div>
			<div class="login-or-register">
				<span>Olá, visitante!</span>
				<a href="">Cadastre-se</a>
				<a href="">Entre</a>
			</div>
			<decorator:getProperty property="page.header-nav"/>
		</div>
	</header>
	
	<decorator:body />
	<c:import url="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>