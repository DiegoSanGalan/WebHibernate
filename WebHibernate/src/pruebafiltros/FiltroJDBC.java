/**
 * 
 */
package pruebafiltros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Diego Santamaria
 *
 */
public class FiltroJDBC implements Filter {
	
	private final Logger log = LogManager.getRootLogger();

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
log.trace("Ha pasado por método **doFilter** de la clase **FiltroJDBC**");
		
		long timeInicio = 0;
		long timeFin = 0;
		// vamos a medir el tiempo que tarda. Para ello cogemos el tiempo
		// que seria el inicio del filtro y despues de usar el doFilter() que 
		// indica que ha vuelto de realizar el servlet.
		timeInicio = System.currentTimeMillis(); //COJO TIEMPO ANTES
		arg2.doFilter(arg0, arg1); // IMPORTANTE para que continue el programa
		timeFin = System.currentTimeMillis(); // COJO TIEMPO AL FINAL
		log.info("El tiempo que tarda JDBC es :" + (timeFin - timeInicio));
		
		ServletContext sc = arg0.getServletContext();
		Integer i = (Integer) sc.getAttribute("peticiones");
		i++;
		sc.setAttribute("peticiones", i);
		log.info("El filtro JDBC se ha llamado: " + i + " veces.");
		
		
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
