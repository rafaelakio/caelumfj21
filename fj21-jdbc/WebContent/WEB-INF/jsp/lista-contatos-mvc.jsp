<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<caelum:pagina>
<h2>Lista de Contatos Cadastrados</h2>
<form action="mvc" method="post" id="formulario">
<table border="1">
<thead>
	<tr>
		<th>Id
		<th>Nome
		<th>Endere�o
		<th>Email
		<th>Data de Nascimento
		<th>Op��es
	</tr>
</thead>
<tbody>
	<c:if test="${!empty idCriado }">Id Criado: ${idCriado }</c:if>
	<c:if test="${!empty idExcluido }">Id Excluido: ${idExcluido }</c:if>
	<c:forEach var="contato" items="${contatos }" varStatus="id">
		<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="dataFormatada"/>
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
			<td>${contato.id }</td>
			<td>${contato.nome }</td>
			<td>${contato.endereco }</td>
			<td>
				<c:choose>
					<c:when test="${empty contato.email }">
						E-mail n�o informado
					</c:when>
					<c:otherwise>
						<a href="mailto:${contato.email }">${contato.email }</a>
					</c:otherwise>
				</c:choose>
			</td>
			<td>${dataFormatada }</td>
			<td>
				<a href="javascript:sbHref('?path=RemoverContato&id=${contato.id }')">Remover</a>
				<a href="javascript:sbHref('?path=AlterarContato&id=${contato.id }')">Alterar</a>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>
</form>
<script type="text/javascript">
function sbHref(path){
	var action = $('#formulario').attr("action");
	$('#formulario').attr("action", action+path);
	$('#formulario').submit();
}
</script>
</caelum:pagina>