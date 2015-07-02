package clasesDAO;

import org.hibernate.Session;

/**
 * Clase contenedor con los atributos comunes a todas las clases DAO
 * @author Diego Santamar�a
 *
 */
public class ContenedorDAO {
	private Session ses;
	
	/**
	 * Constructor B�sico de la clase, sin argumentos.
	 */
	public ContenedorDAO()
	{
		
	}
	
	
	/**
	 * Para obtener la sesi�n 
	 * @return Tipo Session ses
	 */
	public  Session getSes() {
		return ses;
	}

	/**
	 * Para hacer set de la sesi�n del factory
	 * @param session Tipo Session
	 */
	public void setSes(Session session) {
		ses = session;
	}

	
	
	
}
