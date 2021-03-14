package agenda.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.model.AgendaDAO;

@WebServlet(urlPatterns = {"/AgendaController", "/main"})
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AgendaDAO agendaDAO = new AgendaDAO();

    public AgendaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		if(action.equals("/main")) {
			contatos(request, response);
		}
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
	}

}
