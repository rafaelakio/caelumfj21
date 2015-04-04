<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<caelum:pagina>
<h2><c:if test="${empty contato.id }">Adiciona</c:if>
<c:if test="${!empty contato.id }">Altera</c:if> Contatos</h2>
<hr />
<form action="mvc" method="post" id="formulario">
	<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="dataFormatada"/>
	<table>
	<tbody>
		<tr>
			<c:if test="${empty contato.id }"><td></td><td></td></c:if>
			<c:if test="${!empty contato.id }">
			<td><label for="id">Id:</label></td>
			<td><label id="id">${contato.id }</label>
				<input type="hidden" name="id" value="${contato.id }"/>
			</td>
			</c:if>
		</tr>
		<tr>
			<td><label for="nome">Nome:</label></td>
			<td><input type="text" name="nome" value="${contato.nome }"/></td>
		</tr>
		<tr>
			<td><label for="email">E-mail:</label></td>
			<td><input type="text" name="email" value="${contato.email }"/></td>
		</tr>
		<tr>
			<td><label for="endereco">Endereço:</label></td>
			<td><input type="text" name="endereco" value="${contato.endereco }"/></td>
		</tr>
		<tr>
			<td><label for="dataNascimento">Data de Nascimento:</label></td>
			<td><caelum:campoData id="dataNascimento" value="${dataFormatada }"></caelum:campoData></td>
		</tr>
	</tbody>
	</table>
	<input type="hidden" name="path" value="" id="caminho"/>
	<input type="submit" value="Gravar" id="btSubmit"/>
</form>
<script type="text/javascript">
$('#btSubmit').click(function(){
	$('#formulario').attr('method', 'POST');
	$('#caminho').val("AdicionarContato");
});
</script>
</caelum:pagina>