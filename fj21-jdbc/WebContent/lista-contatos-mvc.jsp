<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<caelum:pagina>
<h2>tabela com JSTL</h2>
<table border="1">
<thead>
	<tr>
		<th>Id
		<th>Nome
		<th>Endereço
		<th>Email
		<th>Data de Nascimento
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
						E-mail não informado
					</c:when>
					<c:otherwise>
						<a href="mailto:${contato.email }">${contato.email }</a>
					</c:otherwise>
				</c:choose>
			</td>
			<td>${dataFormatada }</td>
			<td>
				<a href="mvc?path=RemoverContato&id=${contato.id }">Remover</a>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>
</caelum:pagina>