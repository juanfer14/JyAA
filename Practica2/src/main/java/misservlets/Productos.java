package misservlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Productos
 */
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Integer> golosinas;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productos() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext contexto = getServletContext();
		golosinas = new HashMap<>();
		int i = 1;
		String nombre = this.getInitParameter("golo"+i);
		while(nombre != null) {
			Integer precio = Integer.parseInt(this.getInitParameter("pu"+ i));
			contexto.setAttribute("golo"+i, nombre);
			contexto.setAttribute("pu"+i, precio);
			golosinas.put(nombre, precio);
			nombre = this.getInitParameter("golo"+ ++i);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Usuario user = (Usuario) session.getAttribute("usuario");
		
		if(user != null) {
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
				out.println("<title>Productos</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>Seleccione los productos</h1>");
				out.println("<form action=\"/compras/Facturar\" method=\"GET\" id=\"form1\">");
					out.println("<table>");
						out.println("<tr>");
							out.println("<th>Golosina</th>");
							out.println("<th>Precio unitario</th>");
							out.println("<th>Cantidad</th>");
						out.println("</tr>");
						for(String clave: golosinas.keySet()) {
							out.println("<tr>");
								out.println("<td>"+ clave + "</td>");
								out.println("<td>"+ golosinas.get(clave) + "</td>");
								Integer cantActual = user.getCantidadGolosina(clave);
								if(cantActual == null) {
									cantActual = 0;
								}
								out.println("<td><input type=\"number\" min=\"0\" max=\"100\" value=\"" + cantActual.toString()  + "\" name=\"" + clave + "\" /></td>");
							out.println("</tr>");
						}
					out.println("</table>");
					out.println("<button type=\"submit\">Facturar</button>");
					out.println("<a href=\"/compras/TerminarSesion\">Salir</a>");
				out.println("</form>");
				
			out.println("</body>");
			out.println("</html>");
			out.close();
		} else
			response.sendRedirect("/compras/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
