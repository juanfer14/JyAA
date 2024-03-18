package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet(
		name = "login",
		description = "login para usuarios",
		urlPatterns = {"/login"},
		initParams = {
				@WebInitParam(name="users", value="pepe pedro paco"),
				@WebInitParam(name="passwords", value="123 321 312")
		}
)
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginUsr() {
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> users = Arrays.asList(getInitParameter("users").split(" ")); 
		List<String> passw = Arrays.asList(getInitParameter("passwords").split(" "));
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>login</title>");
		out.println("</head>");
		out.println("<body>");
		
		int idx = users.indexOf(request.getParameter("user"));
		if(idx == -1)
			out.println("<h1>El usuario no existe</h1>");
		else if(passw.get(idx).equals(request.getParameter("passw")))
			out.println("<h1>El usuario es valido</h1>");
		else
			out.println("<h1>Los datos ingresados no son validos</h1>");
		
		out.println("<a href=\"login.html\">Link al login</a>");
		out.println("</body>");
		out.println("</html>");
		

		out.close();
	}

}
