<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina Base</title>
</head>
<body>
<c:import url="WEB-INF/jsp/_header.jsp"/>
<jsp:doBody />
<c:import url="WEB-INF/jsp/_footer.jsp"/>
</body>
</html>