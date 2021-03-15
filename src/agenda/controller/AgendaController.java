package agenda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.model.AgendaBean;
import agenda.model.AgendaDAO;

@WebServlet(urlPatterns = {"/AgendaController", "/main", "/insert"})
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AgendaDAO agendaDAO = new AgendaDAO();
	private AgendaBean contato = new AgendaBean();

    public AgendaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		if(action.equals("/main")) {
			contatos(request, response);
		} else if(action.equals("/insert")) {
			novoContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<AgendaBean> listaContatos = agendaDAO.listarContatos();
		request.setAttribute("contatos", listaContatos);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		agendaDAO.inserirContato(contato);
		
		response.sendRedirect("main");
	}

}
