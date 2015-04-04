<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<caelum:pagina>
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizada?</th>
				<th>Data da Finalização</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody id="tarefaBody">
			<c:forEach var="tarefa" items="${tarefas }">
				<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
					pattern="dd/MM/yyyy" var="dataFormatada" />
				<tr>
					<td>${tarefa.id }</td>
					<td>${tarefa.descricao }</td>
					<td>${tarefa.finalizado }</td>
					<td>${dataFormatada }</td>
					<td>
						<a href="remove?id=${tarefa.id }">Remover</a>
						<a href="finaliza?id=${tarefa.id }">Finalizar</a>
						<a href="formulario?id=${tarefa.id }">Alterar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</caelum:pagina>