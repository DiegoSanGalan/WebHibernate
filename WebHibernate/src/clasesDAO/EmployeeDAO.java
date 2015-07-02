package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import clasesDTOAutogeneradas.Employees;
import interfaces.InterfaceDAO;
import interfaces.InterfaceEmployeeDAO;

/**
 * Clase EmployeeDAO para gestionar los m�todos de acceso a la tabla Employee de la base de datos.
 * @author Diego Santamar�a
 * @see InterfaceEmployeeDAO 
 * @see ContenedorDAO
 * 
 *
 */
public class EmployeeDAO  extends ContenedorDAO implements InterfaceEmployeeDAO {

	
	/**
	 * Constructor b�sico de la clase, sin argumentos
	 */
	public EmployeeDAO()
	{
		
	//System.out.println("Constructor EmployeeDAO");	
	
	}

	/**
	 * Insertar empleado
	 * @param Recibo un Objeto Tipo DTO (un Empleado)
	 * @return Devuelvo el Objeto insertado, Si da error devuelvo null
	 */
	@Override
	public Object create(Employees c) {
		Object ok = false;
		
				
		return ok;
	}

	/**
	 * Borrar Empleado por Id
	 * @param Recibo la claveId Tipo Object
	 * @return Booleano a true si es correcto, false si falla
	 */
	@Override
	public boolean delete(Object claveId) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Actualizar empleado
	 * @param Recibo un Empleado
	 * @return Booleano a true si es correcto, false si falla
	 */
	@Override
	public boolean update(Employees c) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * M�todo para leer Empleados al recibir su clave por par�metro
	 * @param claveId tipo Object 
	 * @return Objeto Empleado. Devuelve null si no lo encuentra en la Tabla de la base de datos
	 */
	@Override
	public Employees read(Object claveId) {
		Employees emp = new Employees();
		emp = (Employees) this.getSes().createSQLQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " + claveId).addEntity(Employees.class).uniqueResult();
		if (emp == null)
		{
			System.out.println("***************** El Empleado leido est� a null **************");
			System.out.println("***************** El Empleado leido est� a null **************");
			System.out.println("***************** El Empleado leido est� a null **************");
			System.out.println("***************** El Empleado leido est� a null **************");
		}
		return emp;
	}

	/**
	 * M�todo para obtener todos los registros de la tabla Empleados
	 * @return Lista de Empleados 
	 * 
	 */
	@Override
	public List <Employees> readAll() {
		@SuppressWarnings("unchecked")
		List<Employees> list = getSes().createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();
		return list;
	}

	
	/**
	 * Metodo para obtener todos los registros de la tabla Empleados del Departamento recibido por par�metro
	 * @param dpto Tipo Object
	 * @return Lista de Empleados
	 */
	@Override
	public List<Employees> listadoPorDepartamento(Object dpto) {
		List<Employees> list = this.getSes().createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = " + dpto).addEntity(Employees.class).list();
		return list;
	}
	
	
}
