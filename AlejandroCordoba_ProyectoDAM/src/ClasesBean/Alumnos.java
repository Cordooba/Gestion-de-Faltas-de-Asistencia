package ClasesBean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Alejandro Cordoba Muñoz
 *
 */

public class Alumnos implements Serializable {

	/**
	 * Declaración de variables
	 */
	private static final long serialVersionUID = 1L;
	private int id_Alumno;
	private String curso;
	private String nombre;
	private String apellido;
	private Set <Faltas> faltas = new HashSet<Faltas>();
	
	public Alumnos () {
		
	}
	
	/**
	 * 
	 * @param id_Alumno, parametro identificador alumno
	 * @param curso, parametro curso del alumno
	 * @param nombre, parametro nombre del alumno
	 * @param apellido, parametro apellidos del alumno
	 */
	public Alumnos (int id_Alumno, String curso, String nombre, String apellido) {
		this.id_Alumno=id_Alumno;
		this.curso=curso;
		this.nombre=nombre;
		this.apellido=apellido;
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
	 * @param id_Alumno, recibe como parametro el identificador del alumno
	 */
	public void setId_Alumno(int id_Alumno) {
		this.id_Alumno = id_Alumno;
	}

	/**
	 * 
	 * @return, devuelve el curso del alumno
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * 
	 * @param curso, recibe como parametros el curso del alumno
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * 
	 * @return, devuelve el nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * @param nombre, recibe como parametros el nombre del alumno
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return, devuelve los apellidos del alumno
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @param apellido, recibe como parámetro los apellidos del alumno
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return, devuelve las faltas del alumno
	 */
	public Set<Faltas> getFaltas() {
		return faltas;
	}

	/**
	 * 
	 * @param faltas, recibe como parametros las faltas de asistencia del alumno
	 */
	public void setFaltas(Set<Faltas> faltas) {
		this.faltas = faltas;
	}
}
