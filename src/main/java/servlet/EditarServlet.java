package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import model.Contato;

@WebServlet("/Editar")
public class EditarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : null;
		
		Agenda agenda = Agenda.getInstance();
		
		if (id != null) {
			Contato contato = agenda.carregar(id);
			request.setAttribute("contato", contato);
		}
		
		request.getRequestDispatcher("/editar.jsp").forward(request, response);
	}
}
