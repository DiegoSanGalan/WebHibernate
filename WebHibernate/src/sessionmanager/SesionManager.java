package sessionmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Clase para gestionar las sesiones utilizando Hibernate
 * @author Diego Santamar�a
 *
 */
public class SesionManager {
	
	static {
		
		Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	sesion_factory = configuration.buildSessionFactory(builder.build());
	}
	
	private static SessionFactory sesion_factory;
	
	/**
	 * Constructor privado Clase SesionManager. Singleton
	 */
	private SesionManager (){}
	
	
	/**
	 * Obtener el SessionFactory. static DE MOMENTO NO USADO
	 * ES ESTATIC PORQUE SOLO TENDREMOS UNA DE ESTA CLASE.
	 * @return Objeto sesion_factory
	 */
	public static SessionFactory getSessionFactory ()
	{
		return sesion_factory;
	}
	
	/**
	 * Obtener nueva sesi�n. static
	 * @return Tipo Session
	 */
	public static Session obtenerSesionNueva ()
	{
		return sesion_factory.openSession();
	}
	
	
	/**
	 * M�todo para cerrar la sesi�n
	 * @param sesion Recibe la sesi�n que queremos cerrar
	 */
	public static void cerrarSession (Session sesion)
	{
		sesion.close();
	}
	
	
	/**
	 * Para finalizar todo. Cierra la session_factory
	 */
	public static void cerrarSessionFactory()
	{
		sesion_factory.close();
	}

}
