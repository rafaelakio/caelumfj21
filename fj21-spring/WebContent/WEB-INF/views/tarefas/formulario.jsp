<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<caelum:pagina>
	<h3>Adicionar tarefas</h3>
	<form action="adiciona" method="post" id="formulario">
		<a href="#" style="display: block" id="linkAdiciona">Adicionar uma
			nova tarefa</a>
		<div class="boxFormulario">
			<div class="adicionaFormulario" style="display: none">
				<c:if test="${!empty tarefa.id }">
					<label>Id: </label>
					<label id="lbTarefa">${tarefa.id }</label>
					<input type="hidden" value="${tarefa.id }" name="id" />
					<br />
				</c:if>
				<label>Descri��o:</label>
				<form:errors path="tarefa.descricao" cssStyle="color:red"></form:errors>
				<br />
				<textarea name="descricao" rows="5" cols="100">${tarefa.descricao }</textarea>
				<br /> <input type="hidden" value="${tarefa.finalizado }"
					name="finalizado" /> <input type="hidden" value="${dataFormatada }"
					name="dataFinalizacao" /> <input type="submit" value="Adicionar"
					id="btSubmit" /> <input type="hidden" value="${tarefa.id }"
					id="idAtualizado" />
				<div class="tarefasBox" style="display: none">
					<br />
				</div>
			</div>
			<hr />
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Descri��o</th>
						<th>Finalizada?</th>
						<th>Data da Finaliza��o</th>
						<th>Op��es</th>
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
							<td><a href="remove?id=${tarefa.id }">Remover</a> <a
								href="finaliza?id=${tarefa.id }">Finalizar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
	<fmt:message key="tarefa.incluida.com.sucesso" />
	<script id="tarefasTpl" type="text/template">
	{{tarefas}}
		<td>{.id}</td>
		<td>{.descricao}</td>
		<td>{.finalizado}</td>
	{{/tarefas}}
	</script>
	<script type="text/javascript">
		var init = function() {
			if ($('#lbTarefa').text() != "") {
				$("#btSubmit").val("Alterar");
				$("#formulario").attr("action", "altera");
				$("#h3Tarefas").text("Alterar tarefa");
				$.post("altera");
			}
			if ($('#idAtualizado').val() > 0) {
				$('#linkAdiciona').attr("style", "display:block");
				$.ajax({
					url : "/fj21-spring/tarefas/lista",
					dataType : 'text',
					type : 'post',
					data : $(this).serialize(),
					success : function(data) {
						var response = $.parseJSON(data);
						console.log(response);
						var template = $('#tarefasTpl').html();
						var html = Mustache.to_html(template, response);
						$('#tarefaBody').html(html);
					}
				});
				$('.tarefasBox').attr("style", "display:block");
			}
		}
		init();
		$("#linkAdiciona").click(function() {
			$('.adicionaFormulario').attr("style", "display:block");
			$('#linkAdiciona').attr("style", "display:none");
		});
	</script>
</caelum:pagina>