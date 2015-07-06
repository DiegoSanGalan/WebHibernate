package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletContext;
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
import clasesDTOAutogeneradas.ListaEmpleadosDTO;

/**
 * Servlet implementation class EmpleadosPorDepartamento
 */

public class EmpleadosPorDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosPorDepartamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Operaciones oper = new Operaciones();
		
		String dpto = req.getParameter("lista_dep");
		String[] dptoname = req.getParameterValues("lista_dep");
		System.out.println("LONGITUD DE PARAMETER VALUES: " + dptoname.length);
		System.out.println("dptoname[0].toString()");
		
		for (int i = 0; i<dptoname.length; i++)
		{
			System.out.println("El valor del parameterValues de la posición: " + i + "  es:  " + dptoname[i].toString());
		}
				
		System.out.println("lista_dep: " + dpto);
		
		dpto = dpto.substring(0,dpto.length()-1);
	
		System.out.println("ATRIBUTO ENVIAR: " + dpto);
		
		List<Employees> listEmpleados = new ArrayList<Employees>();
		List<Departments> listDpto = new ArrayList<Departments>();
		
		listEmpleados = oper.obtenerEmpleadosPorDepartamento(dpto);
		listDpto = oper.listaDepartamentos();
		
		Departments dep = new Departments();
		String nombreDpto = "";
		Iterator<Departments> it = listDpto.iterator();
		boolean salir = false;
		
		//Para obtener el nombre del departamento por id
		while (it.hasNext() && (salir==false))
		{
			dep = it.next();
			if (dpto.equals(""+dep.getDepartmentId()))
			{
				nombreDpto = dep.getDepartmentName();
				salir = true;
			}
		}
		
		
		// utilizo éste método para imprimir una tabla con los empleados del departamento
		// elegido en el servlet.
		//imprimirTablaEmpleados(nombreDpto, listEmpleados, resp);
		
		
		// me creo otro método para hacerlo reenviando a un .jsp
		imprimirTablaEmpleadosJSP (nombreDpto, listEmpleados, resp, req);
		
		
		
		
		
							
	}

	/**
	 * Método para generar los datos para enviar a un .jsp con la lista de los
	 * Empleados de un departamento elegido en el select.
	 * @param nombreDpto Tipo String para poder visualizar el nombre del departamento
	 * @param listEmpleados Tipo ArrayList con los DTOS
	 * @param resp
	 * @param req
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void imprimirTablaEmpleadosJSP(String nombreDpto,
			List<Employees> listEmpleados, HttpServletResponse resp,
			HttpServletRequest req) throws ServletException, IOException {
		
		if (null !=listEmpleados) //verifico que existe el empleado
		{
			log.info("El tamaño listEmpleados: " + listEmpleados.size());
			
			//meto el objeto listaEmpleados en la request para poder acceder desde el .jsp llamado
			req.setAttribute("listaemp", listEmpleados); // hay que utilizar el mismo 
			//nombre de atributo que en la .jsp a la que llamamos	
			req.setAttribute("nombredep", nombreDpto);
			
			// redirecciono a la página .jsp para mostrarlo.
			req.getRequestDispatcher("/mostraremppordepto.jsp").forward(req, resp);
					//resp.sendRedirect("MostrarEmpleadoMVC.jsp"); // si lo envió asi no funcionaría porque se 
					//perderian los datos almacenados en el "saco" del request
		}
		else 
		{
			resp.sendRedirect("ErrorEmpleado.html"); //le envio a un .html de error.
		}
		
		
		
		
		
		
		
		
	}

	/**
	 * Método para generar una tabla con los empleados del departamento elegido en el select.
	 * @param nombreDpto
	 * @param listEmpleados
	 * @param resp 
	 * @throws IOException 
	 */
	private void imprimirTablaEmpleados(String nombreDpto,
			List<Employees> listEmpleados, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = null;
		
		resp.setContentType("text/html");
		
		out = resp.getWriter();
		
		
		out.println("<body>");
		out.println("<p size = \"4\" Lista de los empleados del departamento: " + nombreDpto + "</p></br>");
		
		out.println("<table border = \"1\">");
		out.println("<caption>Empleados del departamento <b>"+ nombreDpto +"</b></caption>");
		
		out.println("<tr>");
		out.println("<th align = \"center\"><b>Nombre</b>");
		out.println("</th>");
		
		out.println("<th align = \"center\"><b>Apellido</b>");
		out.println("</th>");
		
		out.println("<th align = \"center\"><b>Salario</b>");
		out.println("</th>");
		
		
		
		out.println("<tr>");
		for (Employees emp : listEmpleados)
		{
			out.println("<tr>");
			//for (int i = 0; i<listEmpleados.size();i++);
			//{
				out.println("<td>");
				out.println(emp.getFirstName());
				out.println("</td>");
				
				out.println("<td>");
				out.println(emp.getLastName());
				out.println("</td>");
				
				out.println("<td>");
				out.println(emp.getSalary());
				out.println("</td>");
				
			//}
				
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		
		
		
	}

}
