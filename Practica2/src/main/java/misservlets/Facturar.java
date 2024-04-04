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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class Facturar
 */
public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Golosinas golosinas;
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
	}
    
    private Integer getPrecioGolosina(Usuario user, String golosina) {
    	return user.getCantidadGolosina(golosina) * golosinas.getPrecio(golosina);
    }
    
    private Integer valorFinal(Usuario user) {
    	return user.getGolosinas().stream().mapToInt(golosina -> this.getPrecioGolosina(user, golosina)).sum();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Usuario user = (Usuario) session.getAttribute("usuario");
			golosinas = (Golosinas)session.getAttribute("precios");
			user.resetGolosinas();
			Enumeration<String> parameters = request.getParameterNames();
			while(parameters.hasMoreElements()) {
				String golosina = parameters.nextElement();
				Integer cantidad = Integer.parseInt(request.getParameter(golosina));
				if(cantidad != null && cantidad != 0)
					user.setCantidadGolosina(golosina, cantidad);
			}
	
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Facturar</title>");
			out.println("</head>");
			out.println("<body>");
				if(user.getGolosinas().isEmpty()) {
					out.println("<h1>No se selecciono ningun producto</h1>");
				} else {
					out.println("<h1>Facturacion del cliente</h1>");
					out.println("<table>");
					out.println("<tr>");
						out.println("<th>Nombre</th>");
						out.println("<th>Cantidad</th>");
						out.println("<th>Precio Total</th>");
					out.println("</tr>");
					for(String clave: user.getGolosinas()) {
						out.println("<tr>");
							out.println("<td>" + clave + "</td>");
							out.println("<td>" + user.getCantidadGolosina(clave).toString() + "</td>");
							out.println("<td>" + this.getPrecioGolosina(user, clave).toString() + "</td>");
						out.println("</tr>");	
					}
					out.println("<tr>");
						out.println("<td></td>");
						out.println("<td>PRECIO FINAL</td>");
						out.println("<td>" + this.valorFinal(user).toString() + "</td>");
					out.println("</tr>");
					out.println("</table>");
					
				}
				out.println("<a href=\"" + response.encodeURL("/compras/Productos") + "\" >Productos</a>");
				out.println("<a href=\"" + response.encodeURL("/compras/TerminarSesion") + "\" >Salir</a>");
			out.println("</body>");
			out.println("</html>");
			
		} else response.sendRedirect("/compras/login.html");
	}

}
