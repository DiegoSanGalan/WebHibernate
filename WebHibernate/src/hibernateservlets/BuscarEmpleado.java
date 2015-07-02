package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.jdbc.clasesDAO.EmpleadoDAO;
import JDBC.jdbc.clasesDTO.Empleados;



public class BuscarEmpleado extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1582692976078981606L;

	
	/**
	 * Servlet para buscar un empleado usando JDBC Y UN PULL
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
		boolean html = true;
		//String nombreyapell = "";
		Connection con = null;
		PrintWriter out = null;
		Empleados empDTO = new Empleados();
		EmpleadoDAO empDAO = new EmpleadoDAO();
		String id = "";
		Pool.getInstance();
		con = Pool.getConnection();
		id = req.getParameter("nombre");
		//System.out.println("*************** " + id);
		
		empDTO =  (Empleados) empDAO.leerEmpleado(id, con);
		
		
		//System.out.println("Ha llamado a doGet");
	
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		//out.printf("Bienvenido a mi casa");
		if (empDTO !=null)
		{
			out.printf(empDTO.toString(html));
		}
		else
		{
			out.printf("El Empleado no existe");
		}
	
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean html = true;
		//String nombreyapell = "";
		Connection con = null;
		PrintWriter out = null;
		Empleados empDTO = new Empleados();
		EmpleadoDAO empDAO = new EmpleadoDAO();
		String id = "";
		Pool.getInstance();
		con = Pool.getConnection();
		id = req.getParameter("nombre");
		//System.out.println("*************** " + id);
		
		empDTO =  (Empleados) empDAO.leerEmpleado(id, con);
		
		
		//System.out.println("Ha llamado a doGet");
	
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		//out.printf("Bienvenido a mi casa");
		if (empDTO !=null)
		{
			out.printf(empDTO.toString(html));
		}
		else
		{
			out.printf("El Empleado no existe");
		}
	
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
}
