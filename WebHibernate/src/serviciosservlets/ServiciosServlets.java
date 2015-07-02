package serviciosservlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase para las operaciones comunes a servlets
 * @author Diego Santamaría
 *
 */
public class ServiciosServlets {
	
	private final Logger log = LogManager.getRootLogger();
	
	/**
	 * Constructor vacío
	 */
	public ServiciosServlets()
	{
		
	}
	

	/**
	 * Método para crear una cookie con el nombre recibido por parámetro
	 * La cookie almacenará la última url a la que ha accedido.
	 * @param req Tipo HttpServletRequest
	 * @param nameCookie Tipo String con el nombre de la cookie a crear
	 * @return Cookie
	 */
	public Cookie crearCookie(HttpServletRequest req, String nameCookie) {
		boolean existe = false;
		Cookie[] listaCookie = null;
		Cookie micookie = null;
		listaCookie = req.getCookies();
		int i = 0;
		int sizeCookie = listaCookie.length;
		while ((i < sizeCookie) && (existe == false))
		{
			if (listaCookie[i].getName().equals(nameCookie))
					{
				existe=true;
				log.info("Cookie encontrada: " + listaCookie[i].getName());
				micookie = listaCookie[i];
					}
			
			i++;
		}
		if (existe==false)
		{
			log.info("Cookie no existe la creo");
				String valor = req.getRequestURI();
				micookie = new Cookie (nameCookie,valor);
				micookie.setComment("Cookie para almacenar la última url");
				micookie.setMaxAge(60);//solo dura un minuto para prueba
		}
		
		return micookie;
	}
	
	
}
