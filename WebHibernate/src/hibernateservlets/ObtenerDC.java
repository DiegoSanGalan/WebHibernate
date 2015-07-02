package hibernateservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ObtenerDC
 */

public class ObtenerDC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerDC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * Para Calcular el DC dado la entidad, oficina y numero de cuenta bancaria
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Sentidad = "";
		String Soficina ="";
		String Scuenta ="";
		Sentidad = request.getParameter("entidad");
		Soficina = request.getParameter("oficina");
		Scuenta = request.getParameter("cuenta");
		PrintWriter out = null;
		
		Integer D = 0;
		Integer C = 0;
		Integer[] entidad = new Integer[4];
		Integer[] oficina = new Integer[4];
		Integer[] cuenta = new Integer[10];
		
		// llenar los array de enteros con los datos recibidos por el string
		for (int i = 0; i<entidad.length; i++)
		{
			entidad[i] = Integer.parseInt(Sentidad.substring(i,i+1));
			//entidad[i] = Integer.parseInt(Sentidad.charAt(i));
			oficina[i] = Integer.parseInt(Soficina.substring(i,i+1));
		}
		for (int i = 0; i<cuenta.length; i++)
		{
			cuenta [i] = Integer.parseInt(Scuenta.substring(i,i+1));
		}
		D = calcularDCPrimero (entidad, oficina);
		C = calcularDCSegundo (cuenta);
		
		//Salida HTML
		//String htmlSalida = "";
		response.setContentType("text/html");
		out = response.getWriter();
		
		out.println("Su número de cuenta completo es: </br>Entidad: " + Sentidad + " Oficina: " + Soficina + " Nº Cuenta: " + Scuenta + "  D.C.: " );
		
		out.print(D);
		out.print(C);
		log.info("El primer dígito del DC es: " + D);
		log.info("El segundo dígito del DC es: " + C);
		
		
		
		
		
	}

	/**
	 * Método para calcular el segundo dígido Bancario DC
	 * @param cuenta
	 * @return
	 */
	private Integer calcularDCSegundo(Integer[] cuenta) {
		/*Para obtener el segundo dígito de control:
		La primera cifra de la cuenta se multiplica por 1
		La primera cifra de la cuenta se multiplica por 2
		La primera cifra de la cuenta se multiplica por 4
		La primera cifra de la cuenta se multiplica por 8
		La primera cifra de la cuenta se multiplica por 5
		La primera cifra de la cuenta se multiplica por 10
		La primera cifra de la cuenta se multiplica por 9
		La primera cifra de la cuenta se multiplica por 7
		La primera cifra de la cuenta se multiplica por 3
		La primera cifra de la cuenta se multiplica por 6
		Se suman todos los resultados obtenidos.
		Se divide entre 11 y nos quedamos con el resto de la división.
		A 11 le quitamos el resto anterior, y ese el el segundo dígito de control, con la salvedad de que si nos da 10, el dígito es 1
		*/
		Integer C = 0;
		int auxCalc = 0;
		
		cuenta [0] = cuenta [0] * 1;
		cuenta [1] = cuenta [1] * 2;
		cuenta [2] = cuenta [2] * 4;
		cuenta [3] = cuenta [3] * 8;
		cuenta [4] = cuenta [4] * 5;
		cuenta [5] = cuenta [5] * 10;
		cuenta [6] = cuenta [6] * 9;
		cuenta [7] = cuenta [7] * 7;
		cuenta [8] = cuenta [8] * 3;
		cuenta [9] = cuenta [9] * 6;
		
		for (int i = 0; i<cuenta.length; i++)
		{
			auxCalc = auxCalc + cuenta[i].intValue();
		}
		auxCalc = auxCalc%11;
		C = new Integer (11 - auxCalc);
		if (C.intValue() >= 10)
		{
			C = 1;
		}
		return C;
	}

	/**
	 * Para calcular el primer dígito del DC
	 * @param entidad
	 * @param oficina
	 * @return
	 */
	private Integer calcularDCPrimero(Integer[] entidad, Integer[] oficina) {

		Integer D = 0;
		int auxCalc = 0;
		//Integer excepcion = new Integer(10);
		
		//operaciones con entidad
		entidad[0] = entidad[0] * 4;
		entidad[1] = entidad[1] * 8;
		entidad[2] = entidad[2] * 5;
		entidad[3] = entidad[3] * 10;
		
		//operaciones con oficina
		oficina[0] = oficina[0] * 9;
		oficina[1] = oficina[1] * 7;
		oficina[2] = oficina[2] * 3;
		oficina[3] = oficina[3] * 6;
		
		//sumar resultados
		for (int i = 0; i<entidad.length; i++)
		{
			auxCalc = auxCalc + (entidad[i].intValue() + oficina[i].intValue());
		}
		//me quedo con el resto de la división
		log.info("VALOR SUMA TOTAL ENTIDAD + OFICINA: " + auxCalc);
		auxCalc = auxCalc%11;
		log.info("VALOR %11 MODULO: " + auxCalc);
		auxCalc = 11 - auxCalc;
		
		
		D = new Integer (auxCalc);
		if (D.intValue()>=10)
		{
			D = 1;
		}
		return D;
	}

}
