<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<caelum:pagina>
	<h3 id="h3Tarefas">Adicionar tarefa</h3>
	<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
					pattern="dd/MM/yyyy" var="dataFormatada" />
	<form action="adiciona" method="post" id="formulario">
		<c:if test="${!empty tarefa.id }">
			<label>Id: </label><label id="lbTarefa">${tarefa.id }</label>
			<input type="hidden" value="${tarefa.id }" name="id"/>
			<br />
		</c:if>
		<label>Descrição:</label>
		<form:errors path="descricao" cssStyle="color:red"></form:errors>
		<br />
		<textarea name="descricao" rows="5" cols="100">${tarefa.descricao }</textarea>
		<br />
		<input type="hidden" value="${tarefa.finalizado }" name="finalizado"/>
		<input type="hidden" value="${dataFormatada }" name="dataFinalizacaoTexto"/>
		<input type="submit" value="Adicionar" id="btSubmit" />
	</form>
<script type="text/javascript">
var init=function(){
	if($('#lbTarefa').text()!=""){
		$("#btSubmit").val("Alterar");
		$("#formulario").attr("action","altera");
		$("#h3Tarefas").text("Alterar tarefa");
	}
}
init();
</script>
</caelum:pagina>