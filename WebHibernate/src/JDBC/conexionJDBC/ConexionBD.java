package JDBC.conexionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import val.examples.threads.Taquilla;

public class ConexionBD {

	// PARAMETROS DE LA CONEXION
	private static final String TEXT_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String TEXT_CONECTAR_BASE_DATOS = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String TEXT_USUARIO = "HR";
	private static final String TEXT_PASS = "DIESAN666";
	
	//creamos un atributo que es la creacion del único objeto de la clase
	// desde aqui si podemos crear un objeto con el constructor private porque estamos en
	// la misma clase  PATRON SINGLETON
	private static ConexionBD miConexion = new ConexionBD();
	
	/*
	Connection conn = null;
	ResultSet rset = null;
	Statement stmt = null;
	PreparedStatement prstmt = null;
	*/
	/**
	 * Constructor privado para que solo haya una sola instancia u objeto de la clase SINGLETON
	 */
	private ConexionBD()
	{
		
	}
	
	public static ConexionBD getConexionBD()
	{
		return miConexion;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection obtenerConexion() throws Exception
	{
			Connection conn = null;
			Class.forName(TEXT_DRIVER);//ejecuta el bloque static de la clase. Que contiene
			conn = DriverManager.getConnection (TEXT_CONECTAR_BASE_DATOS, TEXT_USUARIO, TEXT_PASS);
			return conn;
	}
	
	
	
}
