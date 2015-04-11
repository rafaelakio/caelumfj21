<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<c:url value="../imagens/caelum.png" var="imagem" />

<body>
	<div class="container">
		<header>
			<nav class="navbar navbar-default navbar-static-top">
				<div class="container-fluid">
					<a class="navbar-brand" href="#"> <img src="${imagem}" />
					</a> <br>
					<ul class="nav nav-pills">
						<li role="presentation"><a href="lista">listar tarefas</a></li>
						<li role="presentation"><a href="formulario">adicionar
								tarefas</a></li>
					</ul>
					<br>
					<p class="navbar-text navbar-right">Usuário: ${usuarioLogado.login }
						<a class="navbar-link" href="../login/sair"> (Logout) </a>
					</p>
				</div>
			</nav>

		</header>
		<br> <br>

		<jsp:doBody />

		<footer> Copyright 2010 - Todos os direitos reservados </footer>
	</div>
</body>
</html>
