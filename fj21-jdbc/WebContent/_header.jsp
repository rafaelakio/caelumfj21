<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="imagens/caelum.png" var="imagem"/>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<link href="css/jquery.css" rel="stylesheet">
<table>
	<tr>
		<td>
			<img src="${imagem}"/>
		</td>
		<td>
			<div class="divMenu">
			<table class="tabelaMenu">
			<tr>
				<td class="spanMenu">
					<span>menu</span>
				</td>
				<td class="listaMenu">
					<ul>
						<li><a href="lista-contatos-scriplet.jsp">listar contatos scriplet</a></li>
						<li><a href="lista-contatos-jstl.jsp">listar contatos JSTL</a></li>
						<li><a href="lista-contatos-body.jsp">listar contatos</a></li>
						<li><a href="adiciona-contato-body.jsp">adicionar contato</a></li>
					</ul>
				</td>
			</tr>
			</table>
			</div>
		</td>
	</tr>
</table>
<h1>Agenda de Contatos</h1>
<hr />
<script type="text/javascript">
var listaAtiva = false;
function init(){
	if(listaAtiva) {
		$('.listaMenu').hide();
	}
}
init();
$('.spanMenu').on('mouseover', function(){
	$('.listaMenu').show();
	listaAtiva = true;
});
$('.listaMenu').on('mouseout', function(){
	if(listaAtiva) {
		$('.listaMenu').hide();
	}
});
</script>