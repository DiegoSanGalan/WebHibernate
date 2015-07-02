package pruebafiltros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet Filter implementation class FiltroControlAcceso
 */

public class FiltroControlAcceso implements Filter {
	
	private final Logger log = LogManager.getRootLogger();

    /**
     * Default constructor. 
     */
    public FiltroControlAcceso() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		log.trace("Ha pasado por el método destroy de FiltroControlAcceso");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession httpSes = httpRequest.getSession(false);
		String direccionAutenticar = "/WebHibernate/Autenticacion"; // DIRECCION DEL SERVLET
		String direccionInicial = "/WebHibernate/";
		String direccionCalculadora = "/WebHibernate/CalculadoraDC.html";
		if (httpRequest.getRequestURI().equals(direccionCalculadora))
		{
			chain.doFilter(request, response);
			log.info("han accedido a mi aplicación");
		}
		if (null==httpSes)
		{
			System.out.println("***********DIRECCION URI ********************  " + httpRequest.getRequestURI());
			log.info("Método doFilter del FiltroControlAcesso. La sesión es = null");
			if ((httpRequest.getRequestURI().equals(direccionAutenticar)) || (httpRequest.getRequestURI().equals(direccionInicial)))
			//if (httpRequest.getRequestURI().equals(direccionAutenticar))
				{
				log.info("Le mando a la direccion del Comprobar contraseña y usuario");
				chain.doFilter(request, response);
				}
			else
				{
				if (httpRequest.getRequestURI().equals("/WebHibernate/Login.html"))
					{
						log.info("Le mando a la página principal de login");
						chain.doFilter(request, response);
					}	
				else
					{
						httpResponse.sendRedirect("/WebHibernate");
					}
				}	
		}
		else
		{
		log.info("TIENE SESION Y PASA A CUALQUIER PARTE");
		
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		log.info("FILTRO CONTROL DE ACCESO INICIADO");
		// TODO Auto-generated method stub
	}
}
