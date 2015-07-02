/**
 * 
 */
package clasesDTOAutogeneradas;

import java.io.Serializable;

/**
 * @author Diego Santamaría
 *
 */
public class Usuarios implements Serializable {

	private String nombre="";
	private String clave="";
	
	/**
	 * Constructor vacío de la clase
	 */
	public Usuarios ()
	{
		
	}
	
	/**
	 * @param nombre
	 * @param clave
	 */
	public Usuarios(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
}
