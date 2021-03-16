<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="agenda.model.AgendaBean" %>
<%@ page import="java.util.List" %>
<%
	@SuppressWarnings("unchecked")
	List<AgendaBean> lista = (List<AgendaBean>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/telefone.png" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="navigation" class="navigation">
		<ul>
			<li><a href="index.html"><img alt="home" src="imagens/new-home.png" /></a></li>
		</ul>
	</div>
	<h1 class="agendaContato">Agenda de Contatos</h1>
	<a href="novo.html" class="botao1">Novo Contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0; i < lista.size(); i++) {%>
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="botao1">Editar</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<div class="footer">
  		<span class="footer-copy">&copy; 2021 Ezandro Bueno. Todos os direitos reservados.</span>		
	</div>		
</body>
</html>