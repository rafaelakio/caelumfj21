<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
				br.com.caelum.jdbc.dao.*,
				br.com.caelum.jdbc.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contatos</title>
</head>
<body>
<table>
<thead>
	<tr>
		<td>Id</td>
		<td>Nome</td>
		<td>Endereço</td>
		<td>Email</td>
		<td>Data de Nascimento</td>
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
			<td><%=contato.getDataNascimento().getTime() %></td>
		</tr>
	<%
	}
	%>
</tbody>
</table>
</body>
</html>