package filtros;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroControlaSesion
 */
public class FiltroControlaSesion extends HttpFilter implements Filter {
	private String pathIgnored;
	private String login;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public FiltroControlaSesion() {
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
	public void doFilter(ServletRequest request, ServletResponse response, jakarta.servlet.FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		String path = ((HttpServletRequest) request).getRequestURI();
		System.out.println(path);
		System.out.println(pathIgnored);
		System.out.println(login);
		
		if(path.startsWith(login))
			chain.doFilter(request, response);
		
		if(session == null) {
			if(path.startsWith(pathIgnored))
				chain.doFilter(request, response);
			else
				((HttpServletResponse) response).sendRedirect("/compras/login.html");
		}
		else if(path.startsWith(pathIgnored)) {
			session.invalidate();
			((HttpServletResponse) response).sendRedirect("/compras/login.html");
		}
		else 
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		pathIgnored = fConfig.getInitParameter("LoginUsr");
		login = fConfig.getInitParameter("login");
	}

}
