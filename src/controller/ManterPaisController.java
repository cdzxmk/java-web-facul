package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class PaisServlet
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		Long populacao = Long.parseLong(pPopulacao);
		Double area = Double.parseDouble(pArea);
		
		
		Pais pais = new Pais();
		pais.setNome(nome);
		pais.setPopulacao(populacao);
		pais.setArea(area);
		
		PaisService ps = new PaisService();
		ps.inserir(pais);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Pais Cadastrado</title></head><body>");
		out.println(	"id: "+ pais.getId()+"<br>");
		out.println(	"nome: "+ pais.getNome()+"<br>");
		out.println(	"Populacao: " + pais.getPopulacao()+"<br>");
		out.println(	"Area: "+ pais.getArea()+"<br>");
	    out.println("</body></html>");
		
	}

}
