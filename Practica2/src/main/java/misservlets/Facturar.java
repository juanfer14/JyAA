package misservlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class Facturar
 */
public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Integer> golosinas;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Facturar() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		ServletContext contexto = getServletContext();
		golosinas = new HashMap<String, Integer>();
		int i = 1;
		String nombre = (String) contexto.getAttribute("golo"+i);
		while(nombre != null) {
			Integer precio = (Integer)contexto.getAttribute("pu"+ i);
			golosinas.put(nombre, precio);
			nombre = (String) contexto.getAttribute("golo"+ ++i);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(true);
		Usuario user = (Usuario) session.getAttribute("usuario");
		if(user != null) {
			user.resetGolosinas();
			for(String clave: golosinas.keySet()) {
				Integer cantidad = Integer.parseInt(request.getParameter(clave));
				if(cantidad != null && cantidad != 0) {
					user.setPrecioGolosina(clave, golosinas.get(clave));
					user.setCantidadGolosina(clave, cantidad);
				}
			}
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Facturar</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>Facturacion del cliente</h1>");
				out.println("<table>");
				out.println("<tr>");
					out.println("<th>Nombre</th>");
					out.println("<th>Cantidad</th>");
					out.println("<th>Precio Total</th>");
				out.println("</tr>");
				for(String clave: user.getGolosinas()) {
					System.out.println("CANTIDAD DE LA GOLOSINA " + clave + ": " + user.getCantidadGolosina(clave).toString());
					System.out.println("TOTAL GOLOSINA: " + user.getPrecioCantidadGolosina(clave).toString());
					out.println("<tr>");
						out.println("<td>" + clave + "</td>");
						out.println("<td>" + user.getCantidadGolosina(clave).toString() + "</td>");
						out.println("<td>" + user.getPrecioCantidadGolosina(clave).toString() + "</td>");
					out.println("</tr>");	
				}
				out.println("<tr>");
					out.println("<td></td>");
					out.println("<td>PRECIO FINAL</td>");
					out.println("<td>" + user.getPrecioTotal().toString() + "</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<a href=\"/compras/Productos\">Productos</a>");
				out.println("<a href=\"/compras/TerminarSesion\">Salir</a>");
			out.println("</body>");
			out.println("</html>");
			
		} else response.sendRedirect("/compras/login.html");
	}

}
