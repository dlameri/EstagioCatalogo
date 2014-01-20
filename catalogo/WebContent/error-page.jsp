<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página de erro</title>
</head>
<body>

	<c:choose>
		<c:when test="${message != null}"><h1>${message}</h1></c:when>
		<c:otherwise><h1>Algo inesperado aconteceu... ):</h1></c:otherwise>
	</c:choose>

</body>
</html>