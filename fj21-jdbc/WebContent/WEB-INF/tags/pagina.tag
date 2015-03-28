<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<c:url value="imagens/caelum.png" var="imagem"/>
<link href="css/jquery.css" rel="stylesheet">
<html>
<head>
<title>Inclusão de Contatos</title>
</head>
<body>
<c:import url="_header.jsp"/>
<jsp:doBody />
<c:import url="_footer.jsp"/>
</body>
</html>
