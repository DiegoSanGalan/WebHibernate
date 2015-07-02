package JDBC.jdbc.clasesDTO;

public class Empleados {
	
	private int EMPLOYEE_ID;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL;
	private String PHONE_NUMBER;
	private String HIRE_DATE;
	private String JOB_ID;
	private int SALARY;
	private int COMMISSION_PCT;
	private int MANAGER_ID;
	private int DEPARTMENT_ID;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Empleados EMPLEADO_ID: " + EMPLOYEE_ID + "\n" + "NOMBRE: "
				+ FIRST_NAME + "\n"  + "APELLIDO: " + LAST_NAME + "\n"  + "EMAIL: " + EMAIL + "\n" 
				+ "TELEFONO: " + PHONE_NUMBER + "\n" + "FECHA ALTA: " + HIRE_DATE + "\n" 
				+ "JOB_ID: " + JOB_ID + "\n" + "SALARIO: " + SALARY + "\n" 
				+ "COMISIÓN PCT: " + COMMISSION_PCT + "\n" + "MANAGER_ID: "
				+ MANAGER_ID + "\n" + "DEPARTMENTO_ID: " + DEPARTMENT_ID + "\n" 
				+ "***************************************************\n"
				+ "***************************************************\n";
	}
	
	/**
	 * Método especial toString para formatear salida HTML
	 * @param html Tipo booleano
	 * @return String 
	 */
	public String toString(boolean html)
	{
		return "</br><font size = 5<b><u> Empleados: </b></u></font>" + "</br></br>"  + "<font size = 2><b><u>EMPLEADO_ID: </b></u>" + EMPLOYEE_ID + "</br></br>" + "<b><u>NOMBRE: </b></u>"
				+ FIRST_NAME + "</br></br>"  + "<b><u>APELLIDO: </b></u>" + LAST_NAME + "</br></br>"  + "<b><u>EMAIL: </b></u>" + EMAIL + "</br></br>" 
				+ "<b><u>TELEFONO: </b></u>" + PHONE_NUMBER + "</br></br>" + "<b><u>FECHA ALTA: </b></u>" + HIRE_DATE + "</br></br>" 
				+ "<b><u>JOB_ID: </b></u>" + JOB_ID + "</br></br>" + "<b><u>SALARIO: </b></u>" + SALARY + "</br></br>" 
				+ "<b><u>COMISIÓN PCT: </b></u>" + COMMISSION_PCT + "</br></br>" + "<b><u>MANAGER_ID: </b></u>"
				+ MANAGER_ID + "</br></br>" + "<b><u>DEPARTMENTO_ID: </b></u>" + DEPARTMENT_ID + "</br></br></br></br>" 
				+ "</font>";	
	}


	/**
	 * CONSTRUCTOR CLASE EMPLEADOS
	 * @param idEmpleado
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param telefono
	 * @param fechaContrato
	 * @param jobId
	 * @param salario
	 * @param comision
	 * @param managerID
	 * @param departamentoId
	 */
	public Empleados (int idEmpleado, String nombre, String apellido, String email, String telefono,
			String fechaContrato, String jobId, int salario, int comision, int managerID, int departamentoId)
	
	{
		this.EMPLOYEE_ID = idEmpleado;
		this.FIRST_NAME = nombre;
		this.LAST_NAME = apellido;
		this.EMAIL = email;
		this.PHONE_NUMBER = telefono;
		this.HIRE_DATE = fechaContrato;
		this.JOB_ID = jobId;
		this.SALARY = salario;
		this.COMMISSION_PCT = comision;
		this.MANAGER_ID = managerID;
		this.DEPARTMENT_ID = departamentoId;
	}

	/**
	 * Constructor vacío
	 */
	public Empleados ()
	{
		
	}

	/**
	 * @return the eMPLOYEE_ID
	 */
	public int getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}


	/**
	 * @param eMPLOYEE_ID the eMPLOYEE_ID to set
	 */
	public void setEMPLOYEE_ID(int eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}


	/**
	 * @return the fIRST_NAME
	 */
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}


	/**
	 * @param fIRST_NAME the fIRST_NAME to set
	 */
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}


	/**
	 * @return the lAST_NAME
	 */
	public String getLAST_NAME() {
		return LAST_NAME;
	}


	/**
	 * @param lAST_NAME the lAST_NAME to set
	 */
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}


	/**
	 * @return the eMAIL
	 */
	public String getEMAIL() {
		return EMAIL;
	}


	/**
	 * @param eMAIL the eMAIL to set
	 */
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}


	/**
	 * @return the pHONE_NUMBER
	 */
	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}


	/**
	 * @param pHONE_NUMBER the pHONE_NUMBER to set
	 */
	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}


	/**
	 * @return the hIRE_DATE
	 */
	public String getHIRE_DATE() {
		return HIRE_DATE;
	}


	/**
	 * @param hIRE_DATE the hIRE_DATE to set
	 */
	public void setHIRE_DATE(String hIRE_DATE) {
		HIRE_DATE = hIRE_DATE;
	}


	/**
	 * @return the jOB_ID
	 */
	public String getJOB_ID() {
		return JOB_ID;
	}


	/**
	 * @param jOB_ID the jOB_ID to set
	 */
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}


	/**
	 * @return the sALARY
	 */
	public int getSALARY() {
		return SALARY;
	}


	/**
	 * @param sALARY the sALARY to set
	 */
	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}


	/**
	 * @return the cOMMISSION_PCT
	 */
	public int getCOMMISSION_PCT() {
		return COMMISSION_PCT;
	}


	/**
	 * @param cOMMISSION_PCT the cOMMISSION_PCT to set
	 */
	public void setCOMMISSION_PCT(int cOMMISSION_PCT) {
		COMMISSION_PCT = cOMMISSION_PCT;
	}


	/**
	 * @return the mANAGER_ID
	 */
	public int getMANAGER_ID() {
		return MANAGER_ID;
	}


	/**
	 * @param mANAGER_ID the mANAGER_ID to set
	 */
	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}


	/**
	 * @return the dEPARTMENT_ID
	 */
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}


	/**
	 * @param dEPARTMENT_ID the dEPARTMENT_ID to set
	 */
	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
		

}
