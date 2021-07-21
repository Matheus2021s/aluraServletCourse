package br.com.mariah.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.mariah.gerenciador.model.Banco;
import br.com.mariah.gerenciador.model.Usuario;

public class Autenticar implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String login = request.getParameter("login");
		 String senha = request.getParameter("senha");
		 Banco banco = new Banco();
		 Usuario usuario = banco.existeUsuario(login, senha);
		 if (usuario == null) {
			return  "redirect:entrada?acao=AutenticarForm";
		 } else {
			 HttpSession session = request.getSession();
			 session.setAttribute( "usuario" , usuario );	
			 return "redirect:entrada?acao=ListaEmpresas";
		 }
	}

}
