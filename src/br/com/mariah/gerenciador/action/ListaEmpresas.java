package br.com.mariah.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mariah.gerenciador.model.Banco;
import br.com.mariah.gerenciador.model.Empresa;

public class ListaEmpresas {

		public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Banco banco = new Banco();
			
			List<Empresa> empresas = banco.getEmpresas();
			request.setAttribute("empresas", empresas);
			
			return "foward:listaEmpresas.jsp";

		}
}
