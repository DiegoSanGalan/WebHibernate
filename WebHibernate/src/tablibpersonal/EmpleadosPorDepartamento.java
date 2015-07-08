package tablibpersonal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import clasesDTOAutogeneradas.Employees;

import services.employees.Operaciones;

public class EmpleadosPorDepartamento extends SimpleTagSupport{

	private int id = 0; //declaro el atributo que va a ser modificado desde la etiqueta

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		
		List<Employees> listaemp = new ArrayList<Employees>();
		Operaciones oper = new Operaciones();
		
		listaemp = oper.obtenerEmpleadosPorDepartamento(id);
		if (listaemp.size()==0)
		{
			
		}
		else
		{
			imprimirTablaEmpleados (listaemp);
		}
		
	}
	
	/**
	 * Método para generar una tabla con los empleados del departamento elegido en el select.
	 * @param nombreDpto
	 * @param listEmpleados
	 * @param resp 
	 * @param out2 
	 * @throws IOException 
	 */
	private void imprimirTablaEmpleados(List<Employees> listEmpleados) throws IOException {
		
		//JspWriter out = getJspContext().getOut();
		
		getJspContext().getOut().println("<h2> Lista de los empleados del departamento: </h2>");
		
		getJspContext().getOut().println("<table width = \"50%\" border = \"1\">");
		getJspContext().getOut().println("<caption>Empleados del departamento</caption>");
		
		getJspContext().getOut().println("<tr>");
		getJspContext().getOut().println("<th align = \"center\"><b>Nombre</b>");
		getJspContext().getOut().println("</th>");
		
		getJspContext().getOut().println("<th align = \"center\"><b>Apellido</b>");
		getJspContext().getOut().println("</th>");
		
		getJspContext().getOut().println("<th align = \"center\"><b>Salario</b>");
		getJspContext().getOut().println("</th>");
		
		getJspContext().getOut().println("</tr>");
		
		//out.println("<tr>");
		for (Employees emp : listEmpleados)
		{
			getJspContext().getOut().println("<tr>");
			
			getJspContext().getOut().println("<td>");
			getJspContext().getOut().println(emp.getFirstName());
			getJspContext().getOut().println("</td>");
				
			getJspContext().getOut().println("<td>");
			getJspContext().getOut().println(emp.getLastName());
			getJspContext().getOut().println("</td>");
				
			getJspContext().getOut().println("<td>");
			getJspContext().getOut().println(emp.getSalary());
			getJspContext().getOut().println("</td>");
				
			getJspContext().getOut().println("</tr>");
		}
		
		getJspContext().getOut().println("</table>");
		
		
		
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
