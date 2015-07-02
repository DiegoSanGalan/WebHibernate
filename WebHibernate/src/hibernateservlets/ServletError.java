package hibernateservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet para controlar los errores producidos en todos los servlets.
 * @author Diego Santamaría
 * Servlet implementation class ServletError
 */

public class ServletError extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		Throwable excep = (Throwable) request.getAttribute("javax.servlet.error.exception");
		
		
		Integer codigoHTTP = (Integer) request.getAttribute("javax.servlet.error.status_code"); 
		String nombreServlet = (String) request.getAttribute("javax.servlet.error.servlet_name"); 
		if (null == nombreServlet)
			{
			nombreServlet = "Desconocido";
			}
			 
		String uriPedida = (String) request.getAttribute("javax.servlet.error.request_uri"); 
		
		if (null==uriPedida )
		{
			uriPedida = "Desconocida"; 
		}
		
		log.error("Error del Servlet (DOGET) se redirige al cliente a la pág de error " + excep.getMessage());
		log.error("La Uri Pedida es: " + uriPedida);
		log.error("El nombre del servlet es: " + nombreServlet);
		log.error("El código HTTP del error es: " + codigoHTTP);
		response.sendRedirect("/WebHibernate/ServletError.html");
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Throwable excep = (Throwable) request.getAttribute("javax.servlet.error.exception"); 
		log.error("Error del Servlet (DOPOST) se redirige al cliente a la pág de error " + excep.getMessage());
		response.sendRedirect("/WebHibernate/ServletError.html");
		*/
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		Throwable excep = (Throwable) request.getAttribute("javax.servlet.error.exception"); 
		log.error("Error del Servlet (EN SERVICE) se redirige al cliente a la pág de error " + excep.getMessage());
		response.sendRedirect("/WebHibernate/ServletError.html");
		*/
		
		Throwable excep = (Throwable) request.getAttribute("javax.servlet.error.exception");
		
		
		/*
		Integer codigoHTTP = (Integer) request.getAttribute("javax.servlet.error.status_code"); 
		String nombreServlet = (String) request.getAttribute("javax.servlet.error.servlet_name"); 
		if (null == nombreServlet)
			{
			nombreServlet = "Desconocido";
			}
			 
		String uriPedida = (String) request.getAttribute("javax.servlet.error.request_uri"); 
		
		if (null==uriPedida )
		{
			uriPedida = "Desconocida"; 
		}
		*/
		
		log.error("Error del Servlet (SERVICE) se redirige al cliente a la pág de error " + excep.getMessage());
		//log.error("La Uri Pedida es: " + uriPedida);
		//log.error("El nombre del servlet es: " + nombreServlet);
		//log.error("El código HTTP del error es: " + codigoHTTP);
		response.sendRedirect("/WebHibernate/ServletError.html");
		
		
		
	}
	

}
