package br.com.mariah.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mariah.gerenciador.model.Banco;
import br.com.mariah.gerenciador.model.Empresa;


@WebServlet("/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Banco banco = new Banco();
		
		Empresa empresa = banco.encontraPorId( Long.parseLong( id ) );
		request.setAttribute("empresa", empresa);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editaEmpresa.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome =  request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		String cnpj = request.getParameter("cnpj");
		
		Banco banco = new Banco();
		Empresa empresa = banco.encontraPorId( Long.parseLong( id ) );
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		empresa.setNome(nome);
		try {
			empresa.setDataAbertura( sdf.parse(dataAbertura) );
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		empresa.setCnpj(cnpj);
		
		banco.atualiza(empresa);
		response.sendRedirect("listaEmpresas");
		
	}
}
