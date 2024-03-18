package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encuesta
 */
@WebServlet(
		name = "encuesta",
		description = "Encuesta de mascotas",
		urlPatterns = {"/encuesta"}
)
public class Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int [] mascotas;
	private Map<String, Integer> hashPet;
	private Vector<String> nombres;
    /**
     * Default constructor. 
     */
    public Encuesta() {
    	nombres = new Vector<>();
    	nombres.add("Perro");
    	nombres.add("Gato");
    	nombres.add("Hamster");
    	nombres.add("Tortuga");
    	nombres.add("Loro");
    	nombres.add("Conejo");
    	mascotas = new int[nombres.size()];
    	hashPet = new HashMap<>();
    	hashPet.put("perro", 0);
    	hashPet.put("gato", 1);
    	hashPet.put("hamster", 2);
    	hashPet.put("tortuga", 3);
    	hashPet.put("loro", 4);
    	hashPet.put("conejo", 5);
        // TODO Auto-generated constructor stub
    }
    
    private boolean sumarMascota(String mascota) {
    	if(mascota != null && !mascota.isEmpty() && hashPet.get(mascota) != null) {
    		mascotas[hashPet.get(mascota)]++;
    		return true;
    	}
    	return false;
    }
    
    private int getPuntajeMax() {
    	return Arrays.stream(mascotas).max().getAsInt();
    }
    
    private long getCantTotal() {
    	return Arrays.stream(mascotas).reduce(0, Integer::sum);
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		boolean ok = this.sumarMascota(request.getParameter("mascota"));
		
		out.println("<html>");
		out.println("<head>");
			out.println("<title>Encuesta</title>");
		out.println("</head>");
		out.println("<body>");
		if(ok) {
		
			out.println("<table>");
				out.println("<tr>");
					out.println("<th>Mascota</th>");
					out.println("<th>Votos</th>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>Perro</td>");
					out.println("<td>" + mascotas[0] + "</td>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>Gato</td>");
					out.println("<td>" + mascotas[1] + "</td>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>Hamster</td>");
					out.println("<td>" + mascotas[2] + "</td>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>Tortuga</td>");
					out.println("<td>" + mascotas[3] + "</td>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>Loro</td>");
					out.println("<td>" + mascotas[4] + "</td>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>Conejo</td>");
					out.println("<td>" + mascotas[5] + "</td>");
				out.println("</tr>");
			out.println("</table>");
			
			
			int puntajeMax = this.getPuntajeMax();
			long total = this.getCantTotal();
			double porcentaje = ((double)puntajeMax/total) * 100;
			
			if(puntajeMax > 0) {
				for(int i = 0; i < nombres.size(); i++) {
					if(mascotas[i] == puntajeMax) {
						out.println("<h1>Animal mas votado: " + nombres.get(i) + "</h1>");
						out.println("<h2>Porcentaje: " + String.format("%.2f",porcentaje) + "</h2>");
					}
				}
			}
		} else {
			out.println("<h1>La opcion ingresada no es valida</h1>");
			out.println("<a href=\"mascotas.html\">Volver</a>");
		}
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
