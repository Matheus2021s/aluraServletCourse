package br.com.mariah.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.mariah.gerenciador.model.Banco;
import br.com.mariah.gerenciador.model.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresas();

		String accept = request.getHeader("Accept");

		if (accept.contains("application/xml")) {
			
			XStream xStream = new XStream();
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresas);

			response.setContentType("application/xml");
			PrintWriter writer = response.getWriter();
			writer.print(xml);
		} else if (accept.contains("application/json")) {
			
			Gson gson = new Gson();
			String json = gson.toJson(empresas);

			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.print(json);
		}
	}

}
