<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var = "linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Nova Empresa</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">

		<table>
				<tr>
					<td>
						<label for="nome"> Nome: </label> 
					</td>
					<td>
						<input type="text" name="nome" id="nome" /> 
					</td>
				</tr>
				<tr>
					<td>	
				    	<label for="dataAbertura"> Data abertura: </label> 
					</td>
					<td>
						<input type="text" name="dataAbertura" id="dataAbertura" />
					</td> 
				</tr>
				<tr>
					<td>
						<label for="nome"> Cnpj: </label> 
					</td>
					<td>
						<input type="text" name="cnpj" id="cnpj" /> 
					</td>
				</tr>
				<tr>
					<td>	
						<button type="submit">Cadastrar!</button>
					</td>
				</tr>
		</table>
		<input type="hidden" name="acao" id="acao" value="NovaEmpresa" /> 
	</form>

</body>
</html>