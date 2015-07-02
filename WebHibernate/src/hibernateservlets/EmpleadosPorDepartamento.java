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
		PrintWriter out = null;
		String dpto = req.getParameter("lista_dep");
		String[] dptoname = req.getParameterValues("lista_dep");
		System.out.println("LONGITUD DE PARAMETER VALUES: " + dptoname.length);
		System.out.println("dptoname[0].toString()");
		
		for (int i = 0; i<dptoname.length; i++)
		{
			System.out.println("El valor del parameterValues de la posición: " + i + "  es:  " + dptoname[i].toString());
		}
		//req.getp
				
		System.out.println("lista_dep: " + dpto);
		
		dpto = dpto.substring(0,dpto.length()-1);
	
		
		System.out.println("ATRIBUTO ENVIAR: " + dpto);
		//System.out.println("ATRITUBO ");
		
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
		
		
		
		
		
		/*
		if (listDpto.contains(dpto))
		{
			
		}
		*/
		
		//String select = "<select>";
		//String finselect = "</select>";
		//String optionvalue1 = "<option value = \"";
		//String optionvalue2 = "<\">";
		//String finoption = "</option>";
		
		//String htmlSalida = "";
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		out.println("<body>");
		out.println("<p size = \"4\" Lista de los empleados del departamento: " + nombreDpto + "</p></br>");
		//out.println(select);
		/*
		for (Employees emp : listEmpleados)
		{
			htmlSalida = optionvalue1 + emp.getEmployeeId() + optionvalue2 + emp.getLastName() + finoption ;
			out.println(htmlSalida);
			htmlSalida = "";
		}
		*/
		
		
		
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
		
		
		/*
		<table border="1">
	    <tr>
	      <td></td>
	      <td>&nbsp;</td>
	      <td>&nbsp;</td>
	    </tr>
	    <tr>
	      <td>&nbsp;</td>
	      <td>&nbsp;</td>
	      <td>&nbsp;</td>
	    </tr>
	    <tr>
	      <td>&nbsp;</td>
	      <td>&nbsp;</td>
	      <td>&nbsp;</td>
	    </tr>
	</table>
	*/
		
		
		
		//out.println(finselect);
		
		
		
	}

}
