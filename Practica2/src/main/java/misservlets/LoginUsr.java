package misservlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * Servlet implementation class LoginUsr
 */
public class LoginUsr extends HttpServlet {
	private Hashtable<String, String> users;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsr() {
        // TODO Auto-generated constructor stub
        super();
    }
    
    
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		users = new Hashtable<String, String>(Map.ofEntries(
	        	Map.entry("pepe", this.getInitParameter("pepe")),
	        	Map.entry("pedro", this.getInitParameter("pedro")),
	        	Map.entry("paco", this.getInitParameter("paco"))
	     ));
	}



	private boolean checkLogin(HttpServletRequest request) {
    	return users.containsKey(request.getParameter("usuario")) &&
    			users.containsValue(request.getParameter("pass"));
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(this.checkLogin(request)) {
			HttpSession session = request.getSession(true);
			if(session.isNew()) {
				Usuario user = new Usuario();
				user.setName(request.getParameter("nombre"));
				user.setZipcode(request.getParameter("codigo"));
				session.setAttribute("usuario", user);
			}
			response.sendRedirect("/compras/Productos");
		} else 
			response.sendRedirect("/compras/login.html");
	}

}
