package br.com.mariah.gerenciador.servlet;

import java.io.IOException;

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

		if (acao.equals("ListaEmpresas")) {

			ListaEmpresas lista = new ListaEmpresas();
			lista.executa(request, response);

		} else if (acao.equals("RemoveEmpresa")) {

			RemoveEmpresa remove = new RemoveEmpresa();
			remove.executa(request, response);

		} else if (acao.equals("MostrarDadosEmpresa")) {

			MostraDadosEmpresa dadosEmpresa = new MostraDadosEmpresa();
			dadosEmpresa.executa(request, response);

		} else if (acao.equals("EditaEmpresa")) {

			EditaEmpresa edita = new EditaEmpresa();
			edita.executa(request, response);

		} else if (acao.equals("NovaEmpresa")) {

			NovaEmpresa novaEmpresa = new NovaEmpresa();
			novaEmpresa.executa(request, response);

		}

	}

}
