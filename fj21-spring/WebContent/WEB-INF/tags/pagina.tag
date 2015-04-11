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
	<div class="main">
		<header>
			<nav class="navbar navbar-default navbar-static-top">
				<div class="topbar">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="" href="#"> <img src="${imagem}" /></a>
						</div>
						<div class="col-md-4">
							<ul class="nav nav-pills navbar-nav">
								<li role="presentation"><a href="lista">listar tarefas</a></li>
								<li role="presentation"><a href="formulario">adicionar
										tarefas</a></li>
							</ul>
						</div>
						<div class="col-md-3 navbar-right">
							<p class="navbar-text">
								Usuário: ${usuarioLogado.login } <a class="navbar-link"
									href="../login/sair"> (Logout) </a>
							</p>
						</div>
					</div>
				</div>
			</nav>

		</header>
		<br> <br>
		<section class="no-padding" role="main">
			<div class="container">
				<jsp:doBody />
			</div>
		</section>
	</div>

	<div class="footer">
		<div class="container">
			<footer> Copyright 2010 - Todos os direitos reservados </footer>
		</div>
	</div>
</body>
</html>
