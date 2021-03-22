<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<li><a href="index.html"><img alt="home"
					src="imagens/new-home.png" /></a></li>
			<li><a href="main"><img alt="agenda"
					src="imagens/phone-book.png" /></a></li>
			<li id="threeline-icon" class="threeline-icon" />
		</ul>
	</div>
	<h1 class="novoContato">Editar contato</h1>
	<form action="update" name="frmContato">
		<table>
			<tr>
				<td><input type="text" name="idcon" id="caixa3"
					readonly="readonly"
					value="<%out.print(request.getAttribute("idcon"));%>" /></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa1"
					value="<%out.print(request.getAttribute("nome"));%>" /></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="caixa2"
					value="<%out.print(request.getAttribute("fone"));%>" /></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="caixa1"
					value="<%out.print(request.getAttribute("email"));%>" /></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao1" onclick="validar()" />
	</form>
	<div class="footer">
		<span class="footer-copy">&copy; 2021 Ezandro Bueno. Todos os direitos reservados.</span>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>