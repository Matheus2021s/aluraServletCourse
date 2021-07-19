<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresa cadastrada com sucesso</title>
</head>
	<body>
		<c:if test="${not empty nomeEmpresa}">
			Empresa ${nomeEmpresa} cadastrada com sucesso!
		</c:if>
		<c:if test="${empty nomeEmpresa}">
			Nenhuma empresa cadastrada! 
		</c:if>
		<br />
		<c:forEach var="i" begin="1" end="10" step ="2">
			${i} <br />
		</c:forEach>
	</body>
</html>