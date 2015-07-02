package hibernateservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CLASE DE PRUEBA PARA VER COMO SE COMPRUEBA LA CREACION O NO DE SESIONES
 * @author alumno
 *
 */
public class MiSesionHttp extends HttpServlet {
	
	
	private final Logger log = LogManager.getRootLogger();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//asignamos la sesi�n que existiera al objeto httpSession
		HttpSession htses = req.getSession(false);
		
		//Si no ten�a sesi�n
		if (null==htses) // t�cnica para programar m�s seguro poner primero el null
						// asi si nos equivocamos y ponemos = no puede asignarse a null y 
						// nos daria error. Si est� al rev�s lo asignar�a.
			
			
		{
			htses = req.getSession(); // asociamos nueva sesion
			log.info("Petici�n sin sesi�n asociada. Nueva sesi�n");
		}
		else
		{
			String id = htses.getId(); // capturamos el id
			log.info("Sesion creada ya existe: " + id + " id asociado");
		}
		
		
		
		
		
		
	}
}
