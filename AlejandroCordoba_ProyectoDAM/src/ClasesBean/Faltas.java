package ClasesBean;

import java.io.Serializable;

/**
 * 
 * @author Alejandro Cordoba Muñoz
 *
 */

public class Faltas implements Serializable {

	/**
	 * Declaración de variables
	 */
	private static final long serialVersionUID = 1L;
	private FaltasId id;
	private int horas;
	private Alumnos Alumno;
	private Modulos Modulo;
	
	public Faltas () {
		
	}
	
	/**
	 * 
	 * @param horas, correspondencia con el campo HORAS de la tabla faltas
	 */
	public Faltas (int horas){
		this.horas=horas;
	}

	/**
	 * 
	 * @return, devuelve las horas de la falta de asistencia
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * 
	 * @param horas, recibe como parametro las horas de la falta de asistencia
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * 
	 * @return, devuelve los alumnos correspondiente con una falta de asistencia
	 */
	public Alumnos getAlumno() {
		return Alumno;
	}

	/**
	 * 
	 * @param alumno, recibe como parametro a un alumno
	 */
	public void setAlumno(Alumnos alumno) {
		Alumno = alumno;
	}

	/**
	 * 
	 * @return, devuelve un módulo profesional que tiene registrado faltas de asistencia
	 */
	public Modulos getModulo() {
		return Modulo;
	}

	/**
	 * 
	 * @param modulo, recibe como parametros un módulo profesional
	 */
	public void setModulo(Modulos modulo) {
		Modulo = modulo;
	}

	/**
	 * 
	 * @return, devuelve los campos correspondientes con ID_ALUMNO y ID_MODULO, los identificadores
	 */
	public FaltasId getId() {
		return id;
	}

	/**
	 * 
	 * @param id, recibe como parametro un objeto FaltasId
	 */
	public void setId(FaltasId id) {
		this.id = id;
	}
	
}
