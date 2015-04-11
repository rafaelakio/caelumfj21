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
					<tr id="tarefa-${tarefa.id }">
						<td>${tarefa.id }</td>
						<td>${tarefa.descricao }</td>
						<td id="tdStatus">
							<c:if test="${tarefa.finalizado eq true }">
								Finalizado!
							</c:if>
							<c:if test="${tarefa.finalizado eq false }">
								<a href="javascript:finalizaTarefa(${tarefa.id })">Finalizar</a>
							</c:if>
						</td>
						<td>${dataFormatada }</td>
						<td>
							<a href="javascript:removeTarefa(${tarefa.id })">Remover</a>
							<a href="formulario?id=${tarefa.id }">Alterar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<script type="text/javascript">
		function finalizaTarefa(id) {
			$.post("finaliza", {
				'id' : id
			}, function(resposta) {
				$("#tarefa-"+id+" td:nth-child(3)").text("Finalizado!");
				var $html=$(resposta);
				var $tbody=$html.find("#tarefaBody");
				$("#tarefaBody").html("");
				$("#tarefaBody").html($tbody.html());
			});
		};
		function removeTarefa(id) {
			$.post("remove", {
				'id' : id
			}, function(resposta) {
				$("#tarefa-" + id).closest("tr").remove();
			});
		};
	</script>
</caelum:pagina>