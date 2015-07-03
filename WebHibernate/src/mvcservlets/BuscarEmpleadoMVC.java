package mvcservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import services.employees.Operaciones;
import clasesDTOAutogeneradas.Departments;
import clasesDTOAutogeneradas.Employees;

/**
 * Servlet implementation class BuscarEmpleadoMVC
 */

public class BuscarEmpleadoMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarEmpleadoMVC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Operaciones oper = new Operaciones();
		Employees empDTO = new Employees();
		PrintWriter out = null;
		String id = req.getParameter("empleado");
				
		
		System.out.println("ATRIBUTO ENVIAR: " + id);
		//System.out.println("ATRITUBO ");
		
		
		empDTO = oper.obtenerEmpleado(id);
		if (null !=empDTO) //verifico que existe el empleado
		{
			log.info("El valor del campo empDTO: " + empDTO.getFirstName());
		
		//meto el objeto dto en la request para poder acceder desde el .jsp llamado
		req.setAttribute("empleadoDTO", empDTO); // hay que utilizar el mismo 
			//nombre de atributo que en la .jsp a la que llamamos
		
		// redirecciono a la página .jsp para mostrarlo.
		req.getRequestDispatcher("/MostrarEmpleadoMVC.jsp").forward(req, resp);
		//resp.sendRedirect("MostrarEmpleadoMVC.jsp"); // si lo envió asi no funcionaría porque se 
					//perderian los datos almacenados en el "saco" del request
		}
		else
		{
			resp.sendRedirect("ErrorEmpleado.html"); //le envio a un .html de error.
		}
		
		
		
		
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
