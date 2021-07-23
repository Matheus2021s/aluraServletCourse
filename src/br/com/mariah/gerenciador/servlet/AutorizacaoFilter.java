package br.com.mariah.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response  = (HttpServletResponse) servletResponse;
	
		HttpSession session = request.getSession();
		String acao = request.getParameter("acao");
		
		Boolean isUsuarioNaoAutorizado = session.getAttribute("usuario") == null;
		Boolean isAcaoProtegida = !(acao.equals("Autenticar") || acao.equals("AutenticarForm"));

		if (isAcaoProtegida && isUsuarioNaoAutorizado) {
			response.sendRedirect("entrada?acao=AutenticarForm");
			return;
		}
		
		chain.doFilter(request, response);
	}


}
