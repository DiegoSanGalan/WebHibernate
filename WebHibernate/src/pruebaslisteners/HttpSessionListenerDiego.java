package pruebaslisteners;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpSessionListenerDiego implements HttpSessionListener {
	
	private final Logger log = LogManager.getRootLogger();

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		// También podríamos coger el servlet context del HttpSesion (la sesion creada)
		HttpSession ses = arg0.getSession();
		
		
		//ServletContext sc = ses.getServletContext();
		
		//creamos un objeto ServletContext para acceder al "saco"
		ServletContext sc = arg0.getSession().getServletContext();
		//creamos variable Map para almacenar el mapa recogido desde el ServletContext
		Map<String, HttpSession> mapaUsuariosActivos = new HashMap<String, HttpSession> ();
		mapaUsuariosActivos = (Map<String, HttpSession>) sc.getAttribute("mapusuarios"); // obtengo el mapa
		
		//añado al mapa recuperado los datos de sesion y el nombre del usuario
		// el nombre del usuario lo cojo de la sesion en la que lo había seteado al autenticarse el usuario 
		// LO CAMBIE POR HTTPSESSION Y AHORA AÑADO SOLO LA SESIÓN QUE CONTIENE TODO.
		mapaUsuariosActivos.put(ses.getId(), ses); // actualizo el valor del map metiendo los valores de id, y sesion al map.
		//int i = 0;
		//int longitud = mapaUsuariosActivos.size();
		
		//Iterator<Entry<String, String>> i = mapaUsuariosActivos.entrySet().iterator();
		//Entry entry;
		Iterator it = mapaUsuariosActivos.values().iterator();
		HttpSession sesAux = null; // me creo variable HttpSession para almacenar el valor
								// de la sesión al recorrer el map.
		
		while (it.hasNext())
		{
			// guardo en el log los datos de la sesión cogidos del map que está almacenado en el ServletContext
			sesAux = (HttpSession) it.next();
			log.info("Fecha creación de la Sesión: " + sesAux.getCreationTime());
			log.info("La clave de la Sesión es: " + sesAux.getId());
			log.info("El Nombre Usuario es: " + sesAux.getAttribute("nombre"));
		}
		
		//Vuelvo a meter el mapa actualizado al servletContext
		
		// ******************** NOTA IMPORTANTE **************************
		// COMO COJEMOS UNA REFERENCIA (DIRECCIÓN DE MEMORIA) DEL MAP QUE HAY EN EL SERVLET CONTEXT
		// AL MODIFICARLO NO SERÍA NECESARIO VOLVERLO A CARGAR EN EL SERVLETCONTEXT CON SETATTRIBUTE
		// PORQUE AL SER PASADO POR "REFERENCIA" HEMOS MODIFICADO DIRECTAMENTE EL CONTENIDO.
		// POR LO CUAL LA SIGUIENTE INSTRUCCION NO ES NECESARIA.
		//sc.setAttribute("mapusuarios", mapaUsuariosActivos); // NO ES NECESARIO YA SE HA MODIFICADO
		
		System.out.println("HttpSessionListenerDiego ************** método sessionCreated");
		//log.info("HttpSessionListenerDiego ******* método sessionCreated");
		log.info("El identificador de sesión en SESSIONCREATED es: " + arg0.getSession().getId());
		//añado el nombre de usuario y el id de sesion al mapusuarios
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("HttpSessionListenerDiego ************** método sessionDestroyed");
		log.info("HttpSessionListenerDiego ********** método sessionDestroyed");
		
		//Cuando se destruya una sesion hay que eliminarla del Map que almacenamos en el ServletContext
		ServletContext sc = arg0.getSession().getServletContext(); // creo Acceso a ServletContext
		Map<String, HttpSession> mapaUsuariosActivos = new HashMap<String, HttpSession>();
		mapaUsuariosActivos = (Map<String, HttpSession>) sc.getAttribute("mapusuarios"); // recupero el mapa del ServletContext
		
		
		//if (mapaUsuariosActivos.containsKey(arg0.getSession().getId()))
		//{
			log.info("Eliminada la sesión que ha muerto. ID: " + arg0.getSession().getId());
			log.info("El usuario Eliminado de la Sesión es: NOMBRE: " + arg0.getSession().getAttribute("nombre"));
			mapaUsuariosActivos.remove(arg0.getSession().getId());
		//}
		 
		//NO NECESARIO POR SER PASADO POR REFERENCIA
		//sc.setAttribute("mapusuarios", mapaUsuariosActivos); // vuelvo a volcarlo en el ServletContext.
		
		
		log.info("HttpSessionListenerDiego SE DESCONECTA AUTOMATICAMENTE A LOS DOS MINUTOS");
	}

}
