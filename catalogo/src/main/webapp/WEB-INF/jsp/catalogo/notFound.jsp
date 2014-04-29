<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Página não encontrada</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
		<link href='http://fonts.googleapis.com/css?family=Dosis' rel='stylesheet' type='text/css'>
	</head>

	<body class="error">
		<div>
			<strong class="ops">Ops!</strong>
			<span class="erro-http"> 404 </span>
			<strong class="nao-encontrada"> "I have no memory of this place" </strong>
			
			<a href="javascript:window.history.go(-1)" class="walk-on-home-boy">
			<div class="seta-esquerda"> </div> 
			VOLTAR
			</a>
			
		</div>	
		
	</body>
</html>