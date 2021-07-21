package br.com.mariah.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.mariah.gerenciador.action.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		HttpSession session = request.getSession();
		
		Boolean isUsuarioNaoAutorizado = session.getAttribute("usuario") == null;
		Boolean isAcaoProtegida = !(acao.equals("Autenticar") || acao.equals("AutenticarForm"));
		
		if ( isAcaoProtegida && isUsuarioNaoAutorizado ) {
			response.sendRedirect("entrada?acao=AutenticarForm");
			return;
		}
		
		
		String nomeClasse = "br.com.mariah.gerenciador.action."+acao;
		String nome = null;
		try {
			Class classe = Class.forName(nomeClasse);
			Acao acaoExecutar = (Acao) classe.newInstance();
			nome = acaoExecutar.executa(request, response);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("foward")) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/"+ tipoEEndereco[1]);
			requestDispatcher.forward(request, response);
		
		} else {
			
			response.sendRedirect(tipoEEndereco[1]);

		}
		

	}

}
