package hibernateservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SLogout extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		log.info("HAS HECHO LOGOUT: " + req.getSession().getAttribute("nombre"));
		req.getSession().invalidate();
		resp.sendRedirect("/WebHibernate/");
		
	}

}
