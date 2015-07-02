package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import services.employees.Operaciones;
import clasesDTOAutogeneradas.Departments;


public class ListaDepartamentos extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = null;
		List<Departments> listDepartamentos = new ArrayList<Departments>();
		Operaciones oper = new Operaciones();
		
		listDepartamentos = oper.listaDepartamentos();
		String select = "<select name = \"lista_dep\">";
		String finselect = "</select>";
		String optionvalue1 = "<option value = \"";
		String optionvalue2 = "<\">";
		String finoption = "</option>";
		
		String htmlSalida = "";
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		out.println("<form action=\"EmpleadosPorDepartamento\" method=\"get\">");
		out.println(select);
		
		for (Departments dep : listDepartamentos)
		{
			htmlSalida = optionvalue1 + dep.getDepartmentId() + optionvalue2 + dep.getDepartmentName() + finoption ;
			out.println(htmlSalida);
			htmlSalida = "";
		}
		
		
		out.println(finselect);
		
		out.println("<input type=\"submit\" Value=\"Ver Empleados del Departamento\"/>");
		out.println("</form>");
		
		
		
		
		
		log.info("EL HTML CREADO ES:   " + htmlSalida);
		/*
		 * EJEMPLO DE COMO ES EL CODIGO SELECT HTML
		<select>
  			<option value="volvo">Volvo</option>
  			<option value="saab">Saab</option>
  			<option value="mercedes">Mercedes</option>
  			<option value="audi">Audi</option>
		</select>
		 */
		
		//llamar al Servlet SesionesActivas.
		RequestDispatcher reqDis = req.getRequestDispatcher("SesionesActivas");
		reqDis.include(req, resp);
	}
	
}
