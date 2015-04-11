<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Página de Login das Tarefas</h2>
	<form id="formid" action="#" method="post">
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="password" name="senha" /> <br />
		<a href="#" id="acessa">Acessar as tarefas</a> <br />
		<a href="#" id="adiciona">Criar como novo Usuário</a>
	</form>
<script type="text/javascript">
$('#acessa').click(function(){
	$("#formid").attr("action", "efetuaLogin").submit();
});
$('#adiciona').click(function(){
	$("#formid").attr("action", "cadastraLogin").submit();
});
</script>
</body>
</html>