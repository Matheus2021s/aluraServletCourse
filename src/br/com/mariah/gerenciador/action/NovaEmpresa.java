package br.com.mariah.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mariah.gerenciador.model.Banco;
import br.com.mariah.gerenciador.model.Empresa;

public class NovaEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String dataAbertura = request.getParameter("dataAbertura");
		
		Empresa empresa = new Empresa();
		
		empresa.setNome(nomeEmpresa);
		empresa.setCnpj(cnpj);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataAberturaConvertida = sdf.parse(dataAbertura);
			empresa.setDataAbertura( dataAberturaConvertida );
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("nomeEmpresa", empresa.getNome());
		
		response.sendRedirect("listaEmpresas");
		
	}
}
