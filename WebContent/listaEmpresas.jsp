<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.mariah.gerenciador.model.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var = "linkServletRemoveEmpresa"/>
<c:url value="/entrada" var = "linkServletEditaEmpresa"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
	<h1>Lista de Empresas</h1>
	
	<h2>
		 <c:if test="${not empty nomeEmpresa}">
			Empresa ${nomeEmpresa} cadastrada com sucesso!
		</c:if>
	</h2>
	<table>
		<c:forEach items="${ empresas }" var="empresa">
			<tr>
				<td>${ empresa.nome }</td>
				<td>${ empresa.cnpj }</td>
				<td><fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" /></td>
			<td>
				 <a href="${linkServletEditaEmpresa}?acao=MostrarDadosEmpresa&id=${ empresa.id }"> Editar</a>
			</td>
			<td>
				 <a href="${linkServletRemoveEmpresa}?acao=RemoveEmpresa&id=${ empresa.id }"> Excluir</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>