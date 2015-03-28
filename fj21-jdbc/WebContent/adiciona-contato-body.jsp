<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<script>
$('#botaoGET').on("click", function(){
	$('#formulario').attr('method', 'GET');
});
$('#botaoPOST').on("click", function(){
	$('#formulario').attr('method', 'POST');
});
$('#botaoGETPOST').on("click", function(){
	$('#formulario').attr('method', 'GET');
	$('#formulario').attr('action', 'adicionaContatoPost');
});
$('#botaoService').on("click", function(){
	$('#formulario').attr('method', 'GET');
	$('#formulario').attr('action', 'adicionaContatoService');
});
$('#botao404').on("click", function(){
	$('#formulario').attr('method', 'GET');
	$('#formulario').attr('action', 'adicionaContato404');
});
$("#dataNascimento2").datepicker({
	dateFormat: "dd/mm/yy"
});
</script>
<caelum:pagina>
<h2>Adiciona Contatos</h2>
<hr />
utilize o usuario erroRoot para dar uma exception e redirecionar a pagina<br/>
utilize o usuario destroiServlet para destruir o servlet no servidor<br/>
<!--
POST:
Modifica estado no servidor
nunca é cacheado
um pouco mais seguro pois envia as requisicoes via payload

GET:
parametro sao explicitos
browser usa cache
bookmark
buscadores como o google indexa a pagina
tem um limite de dados enviados na url via queryString
 -->
<form action="adicionaContato" method="post" id="formulario">
	<table>
	<tbody>
		<tr>
			<p> se o id for informado, o contato serão atualizado </p>
			<td><label for="id">Id:</label></td>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td><label for="nome">Nome:</label></td>
			<td><input type="text" name="nome"/></td>
		</tr>
		<tr>
			<td><label for="email">E-mail:</label></td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td><label for="endereco">Endereço:</label></td>
			<td><input type="text" name="endereco"/></td>
		</tr>
		<tr>
			<td><label for="dataNascimento">Data de Nascimento:</label></td>
			<td><input type="text" name="dataNascimento" id="dataNascimento2"/></td>
		</tr>
		<tr>
			<td><label for="dataNascimento">Data de Nascimento taglib:</label></td>
			<td><caelum:campoData id="dataNascimento"></caelum:campoData></td>
		</tr>
	</tbody>
	</table>
	<input type="submit" value="Gravar GET" id="botaoGET"/>
	<input type="submit" value="Gravar POST" id="botaoPOST"/>
	<input type="submit" value="Gravar Service" id="botaoService"/><br />
	<input type="submit" value="Gravar GET em metodo POST" id="botaoGETPOST"/>
	<input type="submit" value="Testa erro 404" id="botao404"/>
</form>
</caelum:pagina>