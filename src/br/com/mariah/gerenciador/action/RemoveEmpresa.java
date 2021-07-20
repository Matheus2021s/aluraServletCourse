package br.com.mariah.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mariah.gerenciador.model.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter( "id" );
		
		Banco banco = new Banco();
		banco.remove( Long.parseLong( id ) );
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}
}
