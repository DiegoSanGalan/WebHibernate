package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SesionesActivas extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
	//private enum contadorCookie {0,1,2};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// busco la cooki y la devuelve si no existe la crea en el método y me la devuelve
		Cookie cooki = crearCookie(req, "micookie");
		String nveces = cooki.getValue();
		Integer cont = new Integer(nveces);
		
		// si ha entrado menos de 3 veces que pase
		if (cont <3)
		{
			cont++;
			String valorString = cont.toString();
			cooki.setValue(valorString);
			resp.addCookie(cooki); //envío la cookie modificada.
		}
		else
		{
			// le echo del proceso informandole que no puede acceder.
			resp.sendRedirect("/WebHibernate/ErrorAccesoSesionesActivas.html");
		}
		
		PrintWriter out = null;
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		ServletContext sc = req.getServletContext();
		Map<String, HttpSession> mapaUsuarios = new HashMap<String, HttpSession>();
		mapaUsuarios = (Map<String, HttpSession>) sc.getAttribute("mapusuarios");
		
		
		//OTRA MANERA DE RECORRER UN HASHMAP LA TENGO EN EL HTTPSESSIONLISTENER
		Iterator<Entry<String, HttpSession>> it = mapaUsuarios.entrySet().iterator();
		Map.Entry<String, HttpSession> e = null;
		while (it.hasNext())
		{
			e = (Entry<String, HttpSession>) it.next();
			log.info("SesionesActivas ***** Clave ID de Sesión: " + e.getKey());
			log.info("SesionesActivas ***** Nombre Usuario de Sesión: " + e.getValue().getAttribute("nombre"));
			
			out.printf("Clave ID de Sesión; " + e.getKey() + "</br>");
			out.printf("Nombre Usuario de Sesión: " + e.getValue().getAttribute("nombre") + "</br>");
			
			
		}
		
		
	}

	
	/**
	 * Método para saber si una cookie recibida por parámetro existe y sino la crea y la devuelve
	 * @param req Tipo HttpServletRequest
	 * @param nameCookie Tipo String que recibe el nombre de la cookie a crear
	 * @return Cookie
	 */
	public Cookie crearCookie(HttpServletRequest req, String nameCookie) {
		boolean existe = false;
		Cookie[] listaCookie = req.getCookies();
		Cookie micookie = null;
		int i = 0;
		//int sizeCookie = listaCookie.length;
		
		if (null==listaCookie)
		{
			log.info("Cookie no existe la creo");
			micookie = new Cookie (nameCookie,"1");
			micookie.setComment("Cookie para limitar el numero de veces");
			micookie.setMaxAge(60*60*24);
		}
		else
		{
			int sizeCookie = listaCookie.length;
			while ((i<sizeCookie) && (!existe))
			{
				if (listaCookie[i].getName().equals(nameCookie))
				{
					existe=true;
					log.info("Cookie encontrada: " + listaCookie[i].getName());
					micookie = listaCookie[i];
				}
				else
				{
					i++;
				}
			}
			if (!existe) //en el caso de que no la encuentre.
			{
			log.info("Cookie no existe la creo");
			micookie = new Cookie (nameCookie,"1");
			micookie.setComment("Cookie para limitar el numero de veces");
			micookie.setMaxAge(60*60*24);
			}
		}
		
		
		return micookie;
	}
}
