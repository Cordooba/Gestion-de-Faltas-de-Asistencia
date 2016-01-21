package ClasesBean;

import java.io.Serializable;

/**
 * 
 * @author Alejandro Cordoba Muñoz
 *
 */

public class FaltasId implements Serializable {

	/**
	 * Declaración de variables
	 */
	private static final long serialVersionUID = 1L;
	private int id_Alumno;
	private int id_Modulo;
	
	public FaltasId () {
		
	}
	/**
	 * 
	 * @param id_Alumno, es el identificador del alumno
	 * @param id_Modulo, es el identificador del modulo
	 */
	public FaltasId (int id_Alumno, int id_Modulo){
		this.id_Alumno=id_Alumno;
		this.id_Modulo=id_Modulo;
	}
	
	/**
	 * 
	 * @return, devuelve el identificador del alumno
	 */
	public int getId_Alumno() {
		return id_Alumno;
	}
	
	/**
	 * 
	 * @param id_Alumno, es el identificador del alumno
	 */
	public void setId_Alumno(int id_Alumno) {
		this.id_Alumno = id_Alumno;
	}
	
	/**
	 * 
	 * @return, devuelve el identificador del alumno
	 */
	public int getId_Modulo() {
		return id_Modulo;
	}

	/**
	 * 
	 * @param id_Modulo, es el identificador del alumno
	 */
	public void setId_Modulo(int id_Modulo) {
		this.id_Modulo = id_Modulo;
	}
	
}
