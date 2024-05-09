package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import clasesdaoImpl.ItemsDAO;
import entitys.Items;

//import clasesdaoImpl.ItemsDAO;
//import entitys.Items;

/**
 * Servlet implementation class GenerarFormulario
 */
public class GenerarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ItemsDAO itemsDAO = new ItemsDAO();
		Items items = itemsDAO.getItems();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Items</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/casamientos/GenerarPresupuesto\" method=\"POST\" ");
		out.println("<label for=\"asistentes\">Cantidad de asistentes</label>");
		out.println("<input type=\"number\" id=\"asistentes\" min=\"0\" value=\"0\" name=\"asistentes\">");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"salon\" value=\"salon\" name=\"opciones\">");
		out.println("<label for=\"salon\">Salon</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"catering\" value=\"catering\" name=\"opciones\">");
		out.println("<label for=\"catering\">Catering</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"barra\" value=\"barra\" name=\"opciones\">");
		out.println("<label for=\"barra\">Barra Libre</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"vino\" value=\"vino\" name=\"opciones\">");
		out.println("<label for=\"vino\">Vino</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"champagne\" value=\"champagne\" name=\"opciones\">");
		out.println("<label for=\"champagne\">Champagne</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"torta\" value=\"torta\" name=\"opciones\">");
		out.println("<label for=\"torta\">Torta</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"animacion\" value=\"animacion\" name=\"opciones\">");
		out.println("<label for=\"animacion\">Animacion</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"ceremonia\" value=\"ceremonia\" name=\"opciones\">");
		out.println("<label for=\"ceremonia\">Ceremonia</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"invitacion\" value=\"invitacion\" name=\"opciones\">");
		out.println("<label for=\"invitacion\">Invitacion</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"alianza\" value=\"alianza\" name=\"opciones\">");
		out.println("<label for=\"alianza\">Alianzas</label>");
		out.println("<br>");
		out.println("<input type=\"checkbox\" id=\"servicio\" value=\"servicio\" name=\"opciones\">");
		out.println("<label for=\"servicio\">Servicio de Video y Fotografia</label>");
		out.println("<br>");
		out.println("<label for=\"nombre\">Nombre: </label>");
		out.println("<input type=\"text\" id=\"nombre\" name=\"nombre\" required>");
		out.println("<br>");
		out.println("<label for=\"email\">Email: </label>");
		out.println("<input type=\"email\" id=\"email\" name=\"email\" required>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"submit\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
