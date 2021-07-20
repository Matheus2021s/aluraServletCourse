package br.com.mariah.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mariah.gerenciador.model.Banco;
import br.com.mariah.gerenciador.model.Empresa;


@WebServlet("/exibirDadosEmpresa")
public class ExibirDadosEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Banco banco = new Banco();
		
		Empresa empresa = banco.encontraPorId( Long.parseLong( id ) );
		request.setAttribute("empresa", empresa);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editaEmpresa.jsp");
		requestDispatcher.forward(request, response);
	}
}
