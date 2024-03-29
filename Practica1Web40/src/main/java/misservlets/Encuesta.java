package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Stream;

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
	private Map<String, Integer> hashPet;
    /**
     * Default constructor. 
     */
    public Encuesta() {
    	hashPet = new HashMap<>();
    	hashPet.put("Perro", 0);
    	hashPet.put("Gato", 0);
    	hashPet.put("Hamster", 0);
    	hashPet.put("Tortuga", 0);
    	hashPet.put("Loro", 0);
    	hashPet.put("Conejo", 0);
        // TODO Auto-generated constructor stub
    }
    
    private boolean sumarMascota(String [] elegidos) {
    	if(elegidos == null) return false;
    	
    	for(String mascota: elegidos) {
    		Integer cant = hashPet.get(mascota);
    		System.out.println(cant);
    		if(cant != null)
	    		hashPet.put(mascota, cant+1);
    	}
    	
    	return true;
    }
    
    private Stream<Integer> getStream() {
    	return hashPet.values().stream();
    }
    
    private int getPuntajeMax() {
    	return this.getStream().max(Integer::compareTo).orElse(0);
    }
    
    private long getCantTotal() {
    	return this.getStream().mapToLong(Integer::longValue).sum();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String [] elegidos = request.getParameterValues("mascota");
		boolean ok = this.sumarMascota(elegidos);
		
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
				for(String clave: hashPet.keySet()) {
					out.println("<tr>");
						out.println("<td>" + clave + "</td>");
						out.println("<td>" + hashPet.get(clave) + "</td>");
					out.println("</tr>");
				}
			out.println("</table>");
			
			
			int puntajeMax = this.getPuntajeMax();
			long total = this.getCantTotal();
			double porcentaje = ((double)puntajeMax/total) * 100;
			
			if(puntajeMax > 0) {
				for(String clave: hashPet.keySet()) {
					if(hashPet.get(clave) == puntajeMax) {
						out.println("<h1>Animal mas votado: " + clave + "</h1>");
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
