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
<style type="text/css">
.input-group-addon, .input-group-btn {
  width: 30%;
  white-space: nowrap;
  vertical-align: middle;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<hr>
	<h3 align="center">Página de Login das Tarefas</h3>
	<div class="col-md" align="center">
		<form id="formid" action="#" method="post">
			<div>
			<div class="input-group">
				<span class="input-group-addon">Login:</span>
				<input type="text" name="login" class="form-control" placeholder="Username" aria-describedby="sizing-addon3" />
			</div>
			<div class="input-group">
				<span class="input-group-addon">Senha:</span>
				<input type="password" name="senha" class="form-control" placeholder="Password" aria-describedby="sizing-addon3" /> <br />
			</div>
			<a href="#" id="acessa">Acessar as tarefas</a> <br />
			<a href="#" id="adiciona">Criar como novo Usuário</a>
			</div>
		</form>
	</div>
	<hr>
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