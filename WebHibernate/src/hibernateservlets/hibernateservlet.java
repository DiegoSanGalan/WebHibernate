package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import services.employees.Operaciones;
import sessionmanager.SesionManager;
import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Employees;

/**
 * Servlet implementation class hibernateservlet
 */

public class hibernateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//inicializamos el Log
	private	final Logger log = LogManager.getRootLogger();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hibernateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Session ses = null;
		//desde aqui también podemos acceder al servletContex que creamos en ServletContextListener.
		ServletContext sc = req.getServletContext();
		SessionFactory sf = null;
		
		//para recuperar el SessionFactory que almacenamos.
		sf = (SessionFactory) sc.getAttribute("sesionfactory"); // recuperamos el objeto asociado a la clave sesionfactory;
		
		ses = sf.openSession(); // obtengo una sesion del SesionFactory
		System.out.println("************* Abrimos y cerramos la sesion *******************");
		System.out.println("************* Abrimos y cerramos la sesion *******************");
		ses.close(); // cierro la sesión.
		
		Operaciones oper = new Operaciones();
		Employees empDTO = new Employees();
		List<Employees> l = new ArrayList<Employees>();
		boolean html = true;
		String id = "";
		PrintWriter out = null;
				
		id = req.getParameter("nombre");
		System.out.println("*************** " + id);
		
		if (id.equals("500"))
		{
			try
			{
				l = oper.listarEmpleadosQueMasGanan();
				log.info("Ejecutado listarEmpleadosQueMasGanan correctamente");
			}
			catch (Exception e)
			{
				log.info("Error al utilizar listarEmpleadosQueMasGanan");
			}
			finally
			{
				
			}
		}
		//int idInt = new Integer(id);
		else
		{
		try
		{
			l = oper.obtenerEmpleadosPorDepartamento(id);
			log.info("Ejecutado ObtenerEmpleadosPorDepartamento correctamente");
		}
		catch (Exception e)
		{
			log.info("Error al utilizar obtenerEmpleadosPorDepartamento");
		}
		finally
		{
			
		}
		}
		
		System.out.println("Ha llamado a doGet");
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		int contadorEmp = 1;
		if (l !=null)
		{
			for (Employees emp : l )
			{
				out.print("Empleado nº: " + contadorEmp + "</br>" + emp.toString(html));
				contadorEmp++;
			}
		}
		else
		{
			out.print("Error, el departamento: " + id + " NO EXISTE");
		}
		
		/*
		if (empDTO !=null)
		{
			out.printf(empDTO.toString(html));
		}
		else
		{
			out.printf("Empleado no existe");
		}
		*/
		
		
		
		//SesionManager.cerrarSessionFactory();
	}

	

}
