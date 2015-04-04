<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<link href="../css/jquery.css" rel="stylesheet">
<c:url value="../imagens/caelum.png" var="imagem"/>
<div class="divMenu">
<table>
	<tr>
		<td>
			<img src="${imagem}"/>
		</td>
		<td class="spanMenu">
			<span>menu</span>
		</td>
		<td class="listaMenu">
			<ul>
				<li><a href="mvc?path=ListarContatos">listar contatos</a></li>
				<li><a href="mvc?path=AlterarContato">adicionar contato</a></li>
			</ul>
		</td>
	</tr>
</table>
					</div>
<h1>Agenda de Contatos</h1>
<hr />
<script type="text/javascript">
function init(){
	$('.listaMenu').hide();
}
init();
$('.divMenu').hover(function(){
	$('.listaMenu').show();
}, function() {
	$('.listaMenu').hide();
});
</script>