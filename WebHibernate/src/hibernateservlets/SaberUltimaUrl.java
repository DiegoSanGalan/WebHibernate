package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import serviciosservlets.ServiciosServlets;

/**
 * Servlet implementation class SaberUltimaUrl
 */

public class SaberUltimaUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaberUltimaUrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = null;
		ServiciosServlets soper = null;
		String mostrarResultado = "";
		Cookie cokieurl = soper.crearCookie(request, "saberurl");
		mostrarResultado = "Datos de la cookie solicitada: </br>" 
				+ "Nombre cookie: " + cokieurl.getName()+ 
				"</br>Valor cookie: " + cokieurl.getValue() + 
				"</br>Comentario de la cookie: " + cokieurl.getComment();
		
		out = response.getWriter();
		out.println(mostrarResultado);
		response.addCookie(cokieurl);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
