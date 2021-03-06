<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<caelum:pagina>
<h2>Adiciona Contatos</h2>
<hr />
utilize o usuario erroRoot para dar uma exception e redirecionar a pagina<br/>
utilize o usuario destroiServlet para destruir o servlet no servidor<br/>
<!--
POST:
Modifica estado no servidor
nunca � cacheado
um pouco mais seguro pois envia as requisicoes via payload

GET:
parametro sao explicitos
browser usa cache
bookmark
buscadores como o google indexa a pagina
tem um limite de dados enviados na url via queryString
 -->
<form action="mvc" method="post" id="formulario">
	<table>
	<tbody>
		<tr>
			<p> se o id for informado, o contato ser�o atualizado </p>
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
			<td><label for="endereco">Endere�o:</label></td>
			<td><input type="text" name="endereco"/></td>
		</tr>
		<tr>
			<td><label for="dataNascimento">Data de Nascimento:</label></td>
			<td><caelum:campoData id="dataNascimento"></caelum:campoData></td>
		</tr>
	</tbody>
	</table>
	<input type="hidden" name="path" value="" id="caminho"/>
	<input type="submit" value="Gravar GET" id="botaoGET"/>
	<input type="submit" value="Gravar POST" id="botaoPOST"/>
	<input type="submit" value="Gravar Service" id="botaoService"/><br />
	<input type="submit" value="Gravar GET em metodo POST" id="botaoGETPOST"/>
	<input type="submit" value="Testa erro 404" id="botao404"/>
</form>
<script type="text/javascript">
$('#botaoGET').click(function(){
	$('#formulario').attr('method', 'GET');
	$('#caminho').val("AdicionarContato");
});
$('#botaoPOST').click(function(){
	$('#formulario').attr('method', 'POST');
	$('#caminho').val("AdicionarContato");
});
$('#botaoGETPOST').click(function(){
	$('#formulario').attr('method', 'GET');
	$('#formulario').attr('action', 'adicionaContatoPost');
});
$('#botaoService').click(function(){
	$('#formulario').attr('method', 'GET');
	$('#formulario').attr('action', 'adicionaContatoService');
});
$('#botao404').click(function(){
	$('#formulario').attr('method', 'GET');
	$('#formulario').attr('action', 'adicionaContato404');
});
$("#dataNascimento2").datepicker({
	dateFormat: "dd/mm/yy"
});
</script>
</caelum:pagina>