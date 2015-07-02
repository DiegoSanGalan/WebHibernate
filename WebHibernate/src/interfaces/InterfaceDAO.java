package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilizaremos �sta interface para hacer cualquier clase que hagamos DAO
 * @author Diego Santamar�a
 *
 */
public interface InterfaceDAO <Generico>{

	// Voy a utilizar generic para poder hacerlo funcionar con cualquier base de datos
	/**
	 * M�todo para crear un registro nuevo en la Base de Datos
	 * @param c Tipo ObjetoDTO
	 * @return booleano indicando true si se cre� correctamente
	 */
	public Object create(Generico c);
	
	
	
	// utilizo tipo Object para que nos sirva con cualquiera
	/**
	 * M�todo para eliminar un registro de la Base de Datos
	 * @param claveId Tipo Object
	 * @return booleano indicando true si borr� correctamente
	 * @throws SQLException 
	 */
	public boolean delete(Object claveId);
	
	
	
	
	/**
	 * M�todo para actualizar en la base de datos
	 * @param c Tipo ObjetoDTO
	 * @return booleano indicando true si se actualiz� correctamente
	 */
	public boolean update(Generico c);
	
	
	
	
	/**
	 * M�todo para leer por ID
	 * @param claveId tipo Object
	 * @return tipo ObjetoDTO
	 */
	public Generico read(Object claveId);
	
	
	
	
	/**
	 * M�todo para recuperar todos los registros de la Base de Datos
	 * @return List del tipo Solicitado
	 */
	public List<Generico> readAll();
	
	
	
}
