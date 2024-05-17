package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroLenguajeDelCliente
 */
public class FiltroLenguajeDelCliente extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroLenguajeDelCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain

		// obtengo el lenguaje del navegador
		HttpServletRequest req = ((HttpServletRequest) (request));
		String language = req.getLocales().nextElement().toString();
		String archivo = null;
		// verifico a partir del lenguaje del navegador, que archivo utilizar
		// y lo guardo
		switch(language) {
			case "en_US":
				archivo = "texto_en.properties";
				break;
			case "es_AR":
				archivo = "texto_es.properties";
				break;
		}
		request.setAttribute("properties", archivo);
		// envio al servlet el nombre del archivo analizado
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
