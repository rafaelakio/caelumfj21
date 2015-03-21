<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,
				java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contatos</title>
</head>
<body>
<h1>tabela com JSTL</h1>
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/>
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
	<c:forEach var="contato" items="${dao.contatos }" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
			<td>${contato.id }</td>
			<td>${contato.nome }</td>
			<td>${contato.endereco }</td>
			<td>${contato.email }</td>
			<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
		</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>