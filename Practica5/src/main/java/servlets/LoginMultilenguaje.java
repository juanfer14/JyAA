package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;


/**
 * Servlet implementation class LoginMultilenguaje
 */
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String properties = (String) request.getAttribute("properties");
		Hashtable<String, String> info = new Hashtable<>();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<header><title>Login</title></header>");
		out.println("<body>");
		try {
			InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/resources/" + properties);
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			int posIgual = 0;
			String linea = r.readLine();
			while(linea != null) {
				posIgual = linea.indexOf("=");
				String clave = linea.substring(0, posIgual);
				String valor = linea.substring(posIgual + 1);
				info.put(clave, valor);
				linea = r.readLine();
			}
			
			out.println("<form action=\"\" method=\"POST\">");
			out.println("<h1>" + info.get("tit")  + "</h1>");
			out.println("<label for=\"user\">" + info.get("usr") + "</label>");
			out.println("<input type=\"text\" id=\"user\" >");
			out.println("<br>");
			out.println("<label for=\"password\">" + info.get("pwd") + "</label>");
			out.println("<input type=\"text\" id=\"password\" >");
			out.println("</form>");
		} catch(IOException e) {
			out.println("<h1>No se encontro el archivo properties o no se pudo leer</h1>");
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
