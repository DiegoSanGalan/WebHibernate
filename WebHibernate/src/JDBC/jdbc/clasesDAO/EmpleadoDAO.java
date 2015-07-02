package JDBC.jdbc.clasesDAO;

//import interfaces.Recuperable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.jdbc.clasesDTO.Empleados;



//import conexionJDBC.ConexionBD;
//import conexionJDBC.InstruccionesSQL;

/**
 * JDBC
 * Clase EmpleadoDAO 
 * Para crear el Objeto de la base de datos que gestiona los métodos con la base de datos
 *
 * @author Diego Santamaría
 *
 */
public class EmpleadoDAO  {
	private static ResultSet rset = null;
	private static Empleados emp = new Empleados();
	private static Statement stmt = null;
	private static PreparedStatement prstmt = null;
	//private static Connection conn = null;

	/**
	 * JDBC
	 * Constructor Vacío EmpleadoDAO
	 */
	public EmpleadoDAO ()
	{
		
	}

	
	/**
	 * Método leerEmpleado de JDBD
	 * @return Object con el empleado del tipo de la clase.
	 * @param idEmp Id del empleado a buscar
	 */
	public Empleados leerEmpleado(String idEmp, Connection conn) {
		
		Empleados empleadoDTO = new Empleados();
		
		
		
		try 
		{
			//conn = ConexionBD.obtenerConexion();
			
			stmt = conn.createStatement();
			prstmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
			prstmt.setString(1, idEmp);
			rset = prstmt.executeQuery();
			if (rset.next())
			{
				int idEmpleado = rset.getInt(1);
				String name= rset.getString(2);
				String apell= rset.getString(3);
				String mail= rset.getString(4);
				String phone= rset.getString(5);
				String alta= rset.getString(6);
				String jobId= rset.getString(7);
				int salario= rset.getInt(8);
				int comision= rset.getInt(9);
				int managerId= rset.getInt(10);
				int departamentoId= rset.getInt(11);
				empleadoDTO = new Empleados (idEmpleado, name, apell, mail, phone, alta, jobId, salario, comision, managerId,departamentoId);
			}
			else 
			{
				empleadoDTO = null;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			
			liberarRecursos();
		}
		
		
	return empleadoDTO;
	}


	private void liberarRecursos() {
		// TODO Auto-generated method stub
		
		if (rset != null) 	
		{ 
			try { rset.close(); 
			} 
			catch (Exception e2) 
			{ e2.printStackTrace(); 
			}
		}
	
	if (stmt != null)	
	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }
	}
	if (prstmt !=null)  
	{ try { prstmt.close(); } catch (Exception e4) { e4.printStackTrace(); }
	}
	//if (conn != null) 	
	//{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }
	//}
		
	}


	
	
}
