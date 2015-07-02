package clasesDAO;

import java.util.List;

import clasesDTOAutogeneradas.Departments;

import interfaces.InterfaceDAO;
import interfaces.InterfaceDepartmentsDAO;


/**
 * 
 * @author Diego Santamar�a
 * Clase DepartmentsDAO para gestionar los m�todos de acceso a la tabla Departments de la base de datos.
 * @see ContenedorDAO
 * @see InterfaceDepartmentsDAO
 *
 */
public class DepartmentsDAO extends ContenedorDAO implements InterfaceDepartmentsDAO{

	

	/**
	 * M�todo para borrar registros de la tabla Departments de la base de datos  por ID.
	 * @param claveId Tipo Object
	 * @return booleano devuelve true si el borrado es correcto.
	 */
	@Override
	public boolean delete(Object claveId) {
		// TODO Auto-generated method stub
		return false;
	}

		

	/**
	 * M�todo para leer todos los registros de la tabla Departments de la base de datos.
	 * @return List<Departments> Lista de todos los registros de la tabla Departments de la base de datos.
	 */ 
	@Override
	public List<Departments> readAll() {
		@SuppressWarnings("unchecked")
		List<Departments> list = getSes().createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list();
		return list;
	}

	
	/**
	 * M�todo para insertar un registro en la tabla Departments de la base de datos.
	 * @param c Tipo Departments. 
	 * @return Tipo Object el Objeto Insertado y null si ha fallado la inserci�n.
	 */
	@Override
	public Object create(Departments c) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * M�todo para actualizar un registro en la tabla Departments de la base de datos.
	 * 
	 * @param c Tipo Departments.
	 * @return booleano a true si es correcta la actualizaci�n
	 */
	@Override
	public boolean update(Departments c) {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * M�todo para leer un registro de la tabla Departments de la base de datos.
	 * @param claveId Tipo Object
	 */
	@Override
	public Departments read(Object claveId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
