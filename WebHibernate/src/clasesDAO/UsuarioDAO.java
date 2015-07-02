/**
 * 
 */
package clasesDAO;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import clasesDTOAutogeneradas.Usuarios;
import interfaces.InterfaceDAO;

/**
 * @author Diego Santamaria
 *
 */
public class UsuarioDAO  extends ContenedorDAO implements InterfaceDAO<Usuarios>{
	private final Logger log = LogManager.getRootLogger();

	

	@Override
	public boolean delete(Object claveId) {
		// TODO Auto-generated method stub
		return false;
	}

	

	/**
	 * Método read de Usuarios.
	 */
	@Override
	public Usuarios read(Object claveId) {
		Usuarios user = new Usuarios();
		user = (Usuarios) this.getSes().createSQLQuery("SELECT * FROM USUARIOS WHERE CLAVE = " + "'"+ claveId+"'").addEntity(Usuarios.class).uniqueResult();
		if (user == null)
		{
			log.info("Error al leer usuario. Usuario no existe ");
		}
		else
		{
			log.info("el usuario existe: " + user.getNombre());
		}
		return user;
	}

	@Override
	public List readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object create(Usuarios c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Usuarios c) {
		// TODO Auto-generated method stub
		return false;
	}

}
