package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import clasesdaoImpl.ItemsDAO;
import clasesdaoImpl.PersonaDAO;
import entitys.Items;
import entitys.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GenerarPresupuesto
 */
public class GenerarPresupuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarPresupuesto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
	}
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		ItemsDAO itemsDAO = new ItemsDAO();
		Items items = itemsDAO.getItems();
		PersonaDAO personaDAO = new PersonaDAO();
		
		Integer asistentes = Integer.parseInt(request.getParameter("asistentes"));
		String [] opciones = request.getParameterValues("opciones");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		if(asistentes != null && opciones != null && nombre != null && email != null) {
			Persona persona = new Persona(nombre, email);
			int total = 1;
			
			for(String opcion: opciones)
				switch(opcion) {
					case "salon":
						total += asistentes * items.getSalon();
						break;
					case "catering":
						total += asistentes * items.getCatering();
						break;
					case "barra":
						total += asistentes * items.getBarra();
						break;
					case "vino":
						total += asistentes * items.getVino();
						break;
					case "champagne":
						total += asistentes * items.getChampagne();
						break;
					case "torta":
						total += asistentes * items.getTorta();
						break;
					case "animacion":
						total += asistentes * items.getSalon();
						break;
					case "ceremonia":
						total += asistentes * items.getCeremonia();
						break;
					case "invitacion":
						total += asistentes * items.getInvitacion();
						break;
					case "alianza":
						total += asistentes * items.getAlianzas();
						break;
					case "servicio":
						total += asistentes * items.getServicio();
						break;
				}
			personaDAO.createPersona(persona);
			out.println("<html>");
			out.println("<head><title>Presupuesto</title></head>");
			out.println("<body>");
			out.println("<h1>" + "El presupuesto es de: " + total + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
		else
			response.sendRedirect("/casamientos/GenerarFormulario");
	}

}
