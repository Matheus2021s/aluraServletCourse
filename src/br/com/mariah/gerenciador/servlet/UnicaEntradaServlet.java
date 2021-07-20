package br.com.mariah.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mariah.gerenciador.action.EditaEmpresa;
import br.com.mariah.gerenciador.action.ListaEmpresas;
import br.com.mariah.gerenciador.action.MostraDadosEmpresa;
import br.com.mariah.gerenciador.action.NovaEmpresa;
import br.com.mariah.gerenciador.action.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String nome = null;

		if (acao.equals("ListaEmpresas")) {

			ListaEmpresas lista = new ListaEmpresas();
			nome = lista.executa(request, response);

		} else if (acao.equals("RemoveEmpresa")) {

			RemoveEmpresa remove = new RemoveEmpresa();
			nome = remove.executa(request, response);

		} else if (acao.equals("MostrarDadosEmpresa")) {

			MostraDadosEmpresa dadosEmpresa = new MostraDadosEmpresa();
			nome = dadosEmpresa.executa(request, response);

		} else if (acao.equals("EditaEmpresa")) {

			EditaEmpresa edita = new EditaEmpresa();
			nome = edita.executa(request, response);

		} else if (acao.equals("NovaEmpresa")) {

			NovaEmpresa novaEmpresa = new NovaEmpresa();
			nome = novaEmpresa.executa(request, response);

		}

		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("foward")) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(tipoEEndereco[1]);
			requestDispatcher.forward(request, response);
		
		} else {
			
			response.sendRedirect(tipoEEndereco[1]);

		}

	}

}
