package pruebaslisteners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import sessionmanager.SesionManager;

public class ServletContextListenerDiego implements ServletContextListener {
	
	//inicializamos el Log
	private	final Logger log = LogManager.getRootLogger();
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		// ************* Para cerrar el Sesion Factory ************
		ServletContext sc = null; // creamos un objeto ServletContext
		SessionFactory sf = null; // creamos un objeto SessionFactory
		sc = arg0.getServletContext(); // en el objeto ServletContext accedemos al saco
		sf = (SessionFactory) sc.getAttribute("sesionfactory"); // recogemos el sesionfactory almacenado en el saco
		System.out.println("*************************************************");
		System.out.println("******** ANTES DE CERRAR EL FACTORY *************");
		System.out.println("*************************************************");
		if (sf != null) // nos aseguramos de que no ha habido ningun error 
		{
			try
			{sf.close(); // cerramos SessionFactory.
			System.out.println("*************************************************");
			System.out.println("****** CERRAMOS EL FACTORY AL FINAL *************");
			System.out.println("*************************************************");
			log.info("Cerramos el Factory Prueba de funcionamiento");
			}
			catch (Exception e)
			{
				System.out.println("Error al cerrar el Factory");
				log.info("error al cerrar el Factory");
			}
			
		}
		log.info("ServletContextListenerDiego ************** método contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Integer nPeticiones = 0; // Para controlar el número de peticiones.
				
		SessionFactory sf = SesionManager.getSessionFactory();
		 // me creo un objeto SessionFactory y lo cojo de SesionManager.
		ServletContext sc = null;
		sc = arg0.getServletContext(); // se crea y se destruye cuando inicio una aplicación
					// es como un saco en el que le puedo hechar cosas (objetos) para luego
					// recuperarlas cuando las necesite mientras corre la aplicación.
		sc.setAttribute("sesionfactory", sf); // seria como hacer variables globales.
			// con setAttribute utilizamos clave (identificador: sesionfactory) - valor (sf Objeto) para almacenar la variable
			// sf del SessionFactory.
			// lo recuperaremos desde el servlet (hibernateservlet)
		//la idea es guardar cosas que me interese recuperar en otro sitio.
		
		sc.setAttribute("peticiones", nPeticiones); // otra cosa que guardamos en el "saco"
		
		//VAMOS A CREAR UN HASHMAP PARA ALMACENAR EN EL SERVLETCONTEXT LAS SESIONES INICIADAS
		// QUE CONTENDRÁ EL IDSESSION Y EL NOMBRE DEL USUARIO. // LO CAMBIO POR HTTPSESSION QUE CONTIENE TODO LO DE LA SESIÓN
		//String idSesion = "";
		//String nombreUsuario = "";
		Map<String,HttpSession> usuariosActivos = new HashMap <String,HttpSession> (); // inicializo el Map
		sc.setAttribute("mapusuarios", usuariosActivos); // introduzco el map en el "saco" servletContext
		
		
		log.info("ServletContextListenerDiego ************** método contextInitialized");
	}
}
