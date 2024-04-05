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
import java.util.Hashtable;
import java.util.Map;

/**
 * Servlet implementation class Productos
 */
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Hashtable<String, Double> golosinas;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			golosinas = (Hashtable<String, Double>) this.getServletContext().getAttribute("golosinas");
			Usuario user = (Usuario) session.getAttribute("usuario");
			if(session.getAttribute("precios") == null)
				session.setAttribute("precios", golosinas);
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
				out.println("<title>Productos</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>Seleccione los productos</h1>");
				out.println("<form action=\"" + response.encodeURL("/compras/Facturar") + "\" method=\"POST\" id=\"form1\">");
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
					out.println("<a href=\"" + response.encodeURL("/compras/TerminarSesion") + "\">Salir</a>");
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
