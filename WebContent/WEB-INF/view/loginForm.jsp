<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var = "linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de login</title>
</head>
<body>
<h1>Acesso ao Sistema de Cadastro de Empresas</h1>
	<form action="${linkEntrada}" method="post">
	<input type="hidden" name="acao" id="acao" value="Autenticar" />
	<table>
		<tr>
			<td>Login:</td>
			<td><input type="text" name="login" id="login"
				placeholder="Insira seu login de acesso"></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" name="senha" id="senha"
				placeholder="Insira sua senha de acesso"></td>
		</tr>
		<tr>
			<td><button type="submit">Acessar</button></td>
		</tr>
	</table>
	</form>

</body>
</html>