<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><decorator:title default="Ideais Electronics"/></title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/header.jsp"/>
	<decorator:body />
	<c:import url="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>