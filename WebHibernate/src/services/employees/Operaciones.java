package services.employees;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import sessionmanager.SesionManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import clasesDAO.DepartmentsDAO;
import clasesDAO.EmployeeDAO;
import clasesDAO.UsuarioDAO;
import clasesDTOAutogeneradas.Departments;
import clasesDTOAutogeneradas.Employees;
import clasesDTOAutogeneradas.Usuarios;

/**
 * Segunda versión mejorada operaciones.
 * @author Diego Santamaria
 *@version Version 2.0
 */
public class Operaciones{
	/**
	 * 
	 */
	
	private final Logger log = LogManager.getRootLogger();
	private EmployeeDAO empleadoDAO = null; // atributo de la clase EmployeeDAO
	private DepartmentsDAO departamentDAO = null; // atributo de la clase DepartmentsDAO
	private UsuarioDAO usuarioDAO = null; // atributo de la clase UsuarioDAO

	
	
	
	
	
	/**
	 * Constructor de la clase Operaciones para empleados
	 */
	public Operaciones ()
	{
		empleadoDAO = new EmployeeDAO();// Instancio el objeto empleadoDAO
		departamentDAO = new DepartmentsDAO();
		usuarioDAO = new UsuarioDAO();
		
		
		//InterfaceDAO<?> empleadoDAO = new EmployeeDAO();
		// podemos utilizar el InterfaceDAO para crear el empleadoDAO y hacerlo más 
		// genérico. De ésta manera no haría falta modificar nada mas que el tipo
		// de la clase EmployeeDAO. HACIENDOLO MAS FLEXIBLE. 
		// PARA QUE FUNCIONE TENDRIA QUE CREAR OTRO INTERFACE HIJO QUE CONTENGA TODOS LOS MÉTODOS
		// DEL EMPLEADODAO
	}
	
	
	/**
	 * Incrementar el salario a todos los empleados
	 * @return booleano a true si se ha incrementado el salario, false si da error
	 */
	public boolean incrementarSalario(String incremento)
	{
	boolean ok = false;
	Transaction transaction = null;	
	Session ses = null;
	ses = SesionManager.obtenerSesionNueva();
	List<Employees> listEmpDTO = new ArrayList<Employees>(); // variable para almacenar la lista de Empleados
	empleadoDAO.setSes(ses); // recupero la sesion de SessionFactory y lo seteo en el contenedor de clasesDAO
		
		//*****************************************************************
		// ***************transaccion incrementar salario******************
		//*****************************************************************
		
	try {
		transaction = empleadoDAO.getSes().beginTransaction();
		listEmpDTO = empleadoDAO.readAll(); //cargo la lista recogida de la base de datos
		actualizarSalario(listEmpDTO, incremento);
		transaction.commit();//si todo ha ido bien, persisto los cambio, los hago de verdad, no en la copia de la BD
		log.info("Se ha incrementado el salario correctamente en la base de datos");
		ok = true;
		}
	catch (Exception e)
		{
		e.printStackTrace();
		log.error("Error en la transacción de incrementar salario");
		transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
	finally 
		{
		SesionManager.cerrarSession(ses); // cierro la sesion
		}
	return ok;
	}
	//*****************************************************************
	//********************** Fin de la transaccion ********************
	//*****************************************************************
	
	
	
	
	
	/**
	 * Recorro la lista y actualizo el salario en 1.2
	 * @param listaEDTO Lista de los Empleados
	 */
	private void actualizarSalario (List<Employees> listaEDTO, String incremento)
	{
		
		for (Employees emp : listaEDTO)
		{
			emp.setSalary(emp.getSalary().multiply(new BigDecimal(incremento)));
		}
	}
	
	
	/**
	 * Método para recuperar una lista con los empleados que más ganan de cada departamento
	 * @return List<Employees> Lista de los empleados que más ganan
	 */
	public List<Employees> listarEmpleadosQueMasGanan ()
	{
		Transaction transaction = null;	
		Session ses = null;
		List<Employees> list = new ArrayList<Employees>(); // para almacenar la lista de empleados que mas ganan
							// de cada departamento.
		List<Departments> listDptos = new ArrayList<Departments>(); // para almacenar lista de departamentos
		
		try
		{
			ses = SesionManager.obtenerSesionNueva();
			empleadoDAO.setSes(ses);
			transaction = empleadoDAO.getSes().beginTransaction();
			listDptos = readAllDepartamentos(); //recuperar lista de departamentos
			for (Departments dpto : listDptos)//recorrer lista de departamentos recogida
			{
			// por cada departamento buscar el empleado que más gana y devolverlo
			// y meterlo en list
			list.add(obtenerElQueMasGana(dpto)); // por cada departamento
			}
			log.info("Transaccion correcta leer departamentos y obtener el que más gana");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.warn("Error en la transacción al leer todos los departamentos");
			transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
		finally
		{
			SesionManager.cerrarSession(ses); // cierro la sesion
		}
		return list;
	}

	
	/**
	 * Método privado para obtener el empleado que mas gana de cada departamento
	 * @param dpto tipo Departments
	 * @return EmpleadoDTO
	 */
	private Employees obtenerElQueMasGana(Departments dpto) {
		Employees empleadoDTOMasGana = null;
		BigDecimal mayor = new BigDecimal (0);
		List<Employees> l = new ArrayList<Employees>();
		l = empleadoDAO.listadoPorDepartamento(dpto); // obtener lista empleados por departamento
		for (Employees emp : l) // recorro la lista
		{
			// si el salario del empleado es mayor que el anterior lo guardo
			if (emp.getSalary().intValue() >  mayor.intValue())
			{
				mayor = emp.getSalary();
				empleadoDTOMasGana = emp;
			}
		}
		return empleadoDTOMasGana;
	}

	
	
	/**
	 * Método privado para obtener una lista de todos los departamentos
	 * @return Lista con todos los departamentos
	 */
	public List<Departments> readAllDepartamentos() 
	{
		List<Departments> listD = departamentDAO.readAll();
		return listD;
	}
	
	
	/**
	 * Método para obtener una lista de los empleados de un departamento recibido por parámetro
	 * @param dpto Tipo Object
	 * @return Lista de empleados Tipo List
	 */
	public List<Employees> obtenerEmpleadosPorDepartamento(Object dpto)
	{
		List <Employees> listEmp2DTO = new ArrayList<Employees>();
		Transaction transaction = null;	
		Session ses = null;
		try
		{
			ses = SesionManager.obtenerSesionNueva();
			empleadoDAO.setSes(ses);
			transaction = empleadoDAO.getSes().beginTransaction();
			listEmp2DTO = empleadoDAO.listadoPorDepartamento(dpto);
			log.info("Transacción correcta al obtener el listado de todos los empleados de un departamento");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("Error en la transacción al obtener el listado por departamentos");
			transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
		finally
		{
			ses.close();
		}
		return listEmp2DTO;
	}
	
	public Employees obtenerEmpleado (Object id)
	{
		Employees empDTO = new Employees();
		Transaction transaction = null;
		Session ses = null;
		
		try
		{
			ses = SesionManager.obtenerSesionNueva();
			empleadoDAO.setSes(ses);
			transaction = empleadoDAO.getSes().beginTransaction();
			empDTO = empleadoDAO.read(id);
			log.info("Transacción correcta al obtener el empleado por id");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("Error al obtener empleado por id");
		}
		finally
		{
			ses.close();
		}
		
		return empDTO;
	}
	
	public Usuarios comprobarUsuario(Object id)
	{
		Usuarios userDTO = new Usuarios();
		Transaction transaction = null;
		Session ses = null;
		
		try
		{
			ses = SesionManager.obtenerSesionNueva();
			usuarioDAO.setSes(ses);
			transaction = usuarioDAO.getSes().beginTransaction();
			userDTO = usuarioDAO.read(id);
			log.info("Usuario leido correctamente");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("Error al obtener un usuario");
		}
		finally
		{
			SesionManager.cerrarSession(ses);
		}
		return userDTO;
	}


	public List<Departments> listaDepartamentos() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Session ses = null;
		List<Departments> listDpto = new ArrayList<Departments>();
		Departments depDTO = new Departments();
		
		try
		{
			ses = SesionManager.obtenerSesionNueva();
			departamentDAO.setSes(ses);
			transaction = departamentDAO.getSes().beginTransaction();
			listDpto = departamentDAO.readAll();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			log.error("Error al obtener listado de departamentos");
		}
		finally
		{
			SesionManager.cerrarSession(ses);
		}
		
		
		
		return listDpto;
	}
	
	
}
