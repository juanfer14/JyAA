package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
/**
 * Servlet implementation class Bienvenida
 */
@WebServlet(
		name = "bienvenida",
		description = "hola mundo",
		urlPatterns = {"/bienvenida"}
)
public class Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Bienvenida() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>bienvenida</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + request.getParameter("nombre") + "</h1>");
		out.println("</body>");
		out.println("<head>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>bienvenida</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + req.getParameter("nombre") + "</h1>");
		out.println("</body>");
		out.println("<head>");
		out.println("</html>");
		out.close();
	}

}
