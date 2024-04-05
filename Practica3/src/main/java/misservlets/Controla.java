package misservlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Controla
 */
public class Controla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controla() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext ctx = this.getServletContext();
		RequestDispatcher dispatcher;
		
		String opcion = request.getParameter("opcion");
		if(opcion != null) {
			switch(opcion) {
				case "hola":
					dispatcher = ctx.getNamedDispatcher("HolaServlet");
					if(dispatcher != null) dispatcher.forward(request, response);
					break;
				case "productos":
					dispatcher = ctx.getContext("/compras").getRequestDispatcher("/Productos");
					if(dispatcher != null) dispatcher.forward(request, response);
					break;
				case "google":
					response.sendRedirect("http://www.google.com.ar");
					break;
				case "default":
					response.sendRedirect("/pruebas/inicio.html");
			}
		} else response.sendRedirect("/pruebas/inicio.html");
	}
		

}
