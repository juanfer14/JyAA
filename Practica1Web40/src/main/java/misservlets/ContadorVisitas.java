package misservlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ContadorVisitas
 */
@WebServlet(
		name = "contador",
		description = "contador de visitas",
		urlPatterns = {"/contador"},
		initParams = {
				@WebInitParam(name="visitas", value="0")
		}
		
)
public class ContadorVisitas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ContadorVisitas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext s = this.getServletContext();
		Object atr = s.getAttribute("visitas");
		int visitas;
		
		if(atr == null)
			visitas = 0;
		else visitas = (int) atr + 1;
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>contador</title>");
		out.println("<body>");
		out.println("<h1>" + "Este servlet lo visitaron: " + visitas +
				" usuarios/s" + "</h1>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		s.setAttribute("visitas", visitas);
		out.close();
		
		
		
	}

}
