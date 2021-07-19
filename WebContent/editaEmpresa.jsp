<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<c:url value="/editaEmpresa" var = "linkServletEditaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Nova Empresa</title>
</head>
<body>
	<form action="${linkServletEditaEmpresa}" method="post">
		<input type="hidden" name="id" id="id" value="${empresa.id}" /> 

		<table>
				<tr>
					<td>
						<label for="nome"> Nome: </label> 
					</td>
					<td>
						<input type="text" name="nome" id="nome" value="${empresa.nome}" /> 
					</td>
				</tr>
				<tr>
					<td>	
				    	<label for="dataAbertura"> Data abertura: </label> 
					</td>
					<td>
						<input type="text" name="dataAbertura" id="dataAbertura" value='<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>' />
					</td> 
				</tr>
				<tr>
					<td>
						<label for="nome"> Cnpj: </label> 
					</td>
					<td>
						<input type="text" name="cnpj" id="cnpj" value="${empresa.cnpj}"  /> 
					</td>
				</tr>
				<tr>
					<td>	
						<button type="submit">Editar!</button>
					</td>
				</tr>
		</table>
		
	</form>

</body>
</html>