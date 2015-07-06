package clasesDTOAutogeneradas;

public class ListaEmpleadosDTO {
	
	
	private int tamArray = 0;
	private Employees[] empleadoDTO = new Employees[tamArray];
	/**
	 * @param tamArray
	 * @param empleadoDTO
	 */
	public ListaEmpleadosDTO(int tamArray, Employees[] empleadoDTO) {
		super();
		this.tamArray = tamArray;
		this.empleadoDTO = empleadoDTO;
	}

	
	public ListaEmpleadosDTO ()
	{
		
	}


	/**
	 * @return the tamArray
	 */
	public int getTamArray() {
		return tamArray;
	}


	/**
	 * @param tamArray the tamArray to set
	 */
	public void setTamArray(int tamArray) {
		this.tamArray = tamArray;
	}


	/**
	 * @return the empleadoDTO
	 */
	public Employees[] getEmpleadoDTO() {
		return empleadoDTO;
	}


	/**
	 * @param empleadoDTO the empleadoDTO to set
	 */
	public void setEmpleadoDTO(Employees[] empleadoDTO) {
		this.empleadoDTO = empleadoDTO;
	}
	
	
	
}
