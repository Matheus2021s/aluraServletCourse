package br.com.mariah.gerenciador.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mariah.gerenciador.model.Banco;
import br.com.mariah.gerenciador.model.Empresa;

public class MostraDadosEmpresa {

	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Banco banco = new Banco();
		
		Empresa empresa = banco.encontraPorId( Long.parseLong( id ) );
		request.setAttribute("empresa", empresa);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editaEmpresa.jsp");
		requestDispatcher.forward(request, response); 
	}
}
