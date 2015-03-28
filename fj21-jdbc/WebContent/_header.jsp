<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="imagens/caelum.png" var="imagem"/>
<table>
	<tr>
		<td>
			<img src="${imagem}"/>
		</td>
		<td>
			<ul>
				<li><a href="listaContatos.jsp">listar scriplet</a></li>
				<li><a href="listaContatosJSTL.jsp">listar JSTL</a></li>
				<li><a href="adiciona-contato.jsp">adicionar contato</a></li>
			</ul>
		</td>
	</tr>
</table>
<h1>Agenda de Contatos</h1>
<hr />