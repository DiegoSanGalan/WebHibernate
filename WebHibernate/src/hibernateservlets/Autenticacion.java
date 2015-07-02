package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import services.employees.Operaciones;
import clasesDTOAutogeneradas.Employees;
import clasesDTOAutogeneradas.Usuarios;

/**
 * Servlet implementation class Autenticacion
 */
public class Autenticacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//inicializamos el Log
		private	final Logger log = LogManager.getRootLogger();
		private int contadorLlamadas = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// para comprobar que los atributos a nivel de clase tienen el mismo valor
		// independientemente de las veces que le llames
		// Lo que esta a nivel de método si es diferente para cada llamada.
		contadorLlamadas++;
		log.info("Numero de llamadas al Servlet: " + contadorLlamadas);
		
		
		Operaciones oper = new Operaciones();
		Usuarios userDTO = new Usuarios();
		//boolean html = true;
		String nombre = "";
		String clave = "";
		PrintWriter out = null;
				
		nombre = req.getParameter("usuario");
		//System.out.println("*************** " + nombre);
		
		clave = req.getParameter("clave");
		//System.out.println("*************** " + clave);
		
		userDTO = oper.comprobarUsuario(clave);
		log.info("Ejecutado comprobarUsuario correctamente");
		
		//log.info("Nombre Usuario: " + userDTO.getNombre());
		//log.info("Clave Usuario: " + userDTO.getClave());
	
		
		System.out.println("Ha llamado a doGet");
		
		resp.setContentType("text/html");
		out = resp.getWriter();
		if (userDTO !=null)
		{	
			if (userDTO.getNombre().equals(nombre))
			{
				if (userDTO.getClave().equals(clave))
				{
					//una vez comprobado que el usuario y contraseña son correctos creo sesión o la recupero si existe
					HttpSession htses = comprobarSesion(req,resp); // creo o recupero la sesion httpSession
					out.print("Bienvenido al programa Sr.: " + nombre + "</br>");
					resp.sendRedirect("/WebHibernate/Menu.html");
					//cuando el usuario y contraseña son correctos, guardamos
					// el nombre del usuario en el "saco" htses.
					htses.setAttribute("nombre", nombre);
					
				}
				else
				{
					out.print("Error, Clave incorrecta:  " + nombre);
				}
			
			}
			else
			{
				out.print("Error, Nombre Usuario Incorrecto:  " + nombre);
			}
		}
		else
		{
			out.print("Error, El usuario no existe. " + nombre);
		}
		
		out.println("Numero de llamadas al Servlet: " + contadorLlamadas);
		
		
	}

	private HttpSession comprobarSesion(HttpServletRequest req,
			HttpServletResponse resp) {
		
		//asignamos la sesión que existiera al objeto httpSession
		HttpSession htses = req.getSession(false);
						
		//Si no tenía sesión
		if (null==htses) // técnica para programar más seguro poner primero el null
						// asi si nos equivocamos y ponemos = no puede asignarse a null y 
						// nos daria error. Si está al revés lo asignaría.
			{
			htses = req.getSession(); // asociamos nueva sesion
			log.info("Petición sin sesión asociada. Nueva sesión");
			}
		else
			{
			String id = htses.getId(); // capturamos el id
			log.info("Sesion creada ya existe: " + id + " id asociado");
			}
		return htses;
		
	}

}
