/**
 * 
 */
package interfaces;

import java.util.List;

import clasesDTOAutogeneradas.Employees;

/**
 * Interface espec�fica de Empleados DAO que hereda de InterfaceDAO
 * @author Diego Santamar�a
 * @see InterfaceDAO
 * 
 *
 */
public interface InterfaceEmployeeDAO extends InterfaceDAO<Employees> {

	
	/**
	 * M�todo para devolver un listado del departamento recibido por par�metro
	 * @param dpto tipo short (Object)
	 * @return Lista de Empleados
	 */
	public List<Employees>listadoPorDepartamento (Object dpto);
	
	
}
