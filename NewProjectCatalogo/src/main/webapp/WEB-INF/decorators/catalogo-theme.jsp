<?xml version="1.0" encoding="UTF-8" ?>
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
	<c:import url="/WEB-INF/jsp/header.jsp"/>
	<decorator:body />
	<c:import url="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>