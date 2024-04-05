package misservlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.Hashtable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Application Lifecycle Listener implementation class InicializaStock
 *
 */
public class InicializaStock implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializaStock() {
        // TODO Auto-generated constructor stub
    }
    
    private String getUrl(ServletContextEvent sce, String param) {
    	return sce.getServletContext().getInitParameter(param);
    }
    
    private InputStream getInput(ServletContextEvent sce) throws IOException {
    	return sce.getServletContext().getResourceAsStream(this.getUrl(sce, "stock"));
    }
    
    private BufferedReader getReader(ServletContextEvent sce) throws IOException {
    	return new BufferedReader(new InputStreamReader(this.getInput(sce)));
    }
    
    private String getNombre(String linea, int coma) {
    	return linea.substring(0, coma);
    }
    
    private Double getPrecio(String linea, int coma) {
    	return Double.parseDouble(linea.substring(coma+1));
    }
    
    private Hashtable<String, Double> getProductos(BufferedReader r) throws IOException{
    	Hashtable<String, Double> productos = new Hashtable<>();
    	String linea = r.readLine();
    	while(linea != null) {
    		int posComa = linea.indexOf(',');
    		productos.put(this.getNombre(linea, posComa), this.getPrecio(linea, posComa));
    		linea = r.readLine();
    	}
    	r.close();
    	return productos;
    }
    
    private Hashtable<String, Double> getLista(ServletContextEvent sce) throws IOException {   	
    	return this.getProductos(this.getReader(sce));
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	try {
    		sce.getServletContext().setAttribute("golosinas", this.getLista(sce));
    		sce.getServletContext().log("Productos cargados");
    	} catch(IOException e) {
    		sce.getServletContext().log("Error al cargar productos", e);
    	}
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
