package hibernateservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class BorrarCookies
 */
public class BorrarCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//limpiear cookies
		Cookie[] arrayCookie = request.getCookies();
		for (int i = 0; i<arrayCookie.length;i++)
		{
			arrayCookie[i].setMaxAge(0);
			log.info("cookie borrada: " + arrayCookie[i].getName());
			response.addCookie(arrayCookie[i]);// se la envio al navegador para que no me devuelva la cookie la siguiente vez
		}
		
		response.sendRedirect("/WebHibernate/Menu.html");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
