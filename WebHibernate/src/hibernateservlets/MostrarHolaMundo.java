package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarHolaMundo
 */

public class MostrarHolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarHolaMundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = null;
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		String mostrar = "<html> <head> <title>Hola Mundo</title> </head>" + "<body> <p>Hola, esto es una página JSP.</p>" 
			+"<p>La hora del servidor es: " + new Date() + "</body>	</html> ";
		
		
		out.println(mostrar);
		
		/*
		<%@ page language='java' contentType='text/html;charset=iso-8859-1'%> 
		<%@ page import='java.util.Date' %> 
			<html> <head> <title>Hola Mundo</title> </head> 
			<body> <p>Hola, esto es una página JSP.</p> 
			<p>La hora del servidor es <%= new Date() %></p> 
			</body> 
		</html> 
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
