<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<caelum:pagina>
<h3>Adicionar tarefas</h3>
<form action="adiciona" method="post">
	Descrição: <br />
	<textarea name="descricao" rows="5" cols="100"></textarea><br />
	<input type="submit" value="Adicionar"/>
	<input type="hidden" value="${idAtualizado }" id="idAtualizado"/>
	<div class="tarefasBox" style="display:none">
		<table>
			<thead>
				<tr>
					<th>Id
					<th>Descrição
					<th>Finalizada?
					<th>Data da Finalização
		
	}		</th>
			</thead>
		</table>
	</div>
</form>
<script type="text/javascript">
var init=function(){
	if($('#idAtualizado').val()>0){
		$('.tarefasBox').attr("display", "block");
	}
}
init();
</script>
</caelum:pagina>