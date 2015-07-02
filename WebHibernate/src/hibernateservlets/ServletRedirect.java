package hibernateservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletRedirect extends HttpServlet {

	
	private final Logger log = LogManager.getRootLogger();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		log.info("Redireccionando a una página web");
		//Para redireccionar a otra url
		resp.sendRedirect("https://github.com/DiegoSanGalan");
		
		
	}
	
}


