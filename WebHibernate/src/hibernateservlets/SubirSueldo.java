package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import services.employees.Operaciones;
import clasesDTOAutogeneradas.Employees;

public class SubirSueldo extends HttpServlet{
	
	private final Logger log = LogManager.getRootLogger();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * USAREMOS DOPOST PORQUE VAMOS A MODIFICAR EN LA BASE DE DATOS.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletConfig conf=getServletConfig();
		String incremento=conf.getInitParameter("porcentaje");

		
		
		Operaciones oper = new Operaciones();
		PrintWriter out = null;
				
		
		
		try
		{
			if (oper.incrementarSalario(incremento))
				{
				
				log.info("salario incrementado * " + incremento + " ");
				}
			log.info("Ejecutado incrementarSalario correctamente");
		}
		catch (Exception e)
		{
			log.info("Error al utilizar incrementarSalario");
		}
		finally
		{
			
		}
		
		System.out.println("Ha llamado a doGet");
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		
		out.print("Salario incrementado correctamente</br>");
		
		
		
	}
		
		

	
	

}
