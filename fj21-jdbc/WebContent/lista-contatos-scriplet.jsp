<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,
				java.text.*,
				br.com.caelum.jdbc.dao.*,
				br.com.caelum.jdbc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contatos</title>
</head>
<body>
<c:import url="_header.jsp"/>
<h2>tabela com scriptlet</h2>
<table>
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
	<%
	ContatoDao dao = new ContatoDao();
	List<Contato> contatos = dao.getContatos();
	for (Contato contato : contatos) {
	%>
		<tr>
			<td><%=contato.getId() %></td>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%= new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()) %></td>
		</tr>
	<%
	}
	%>
</tbody>
</table>
<c:import url="_footer.jsp"/>
</body>
</html>