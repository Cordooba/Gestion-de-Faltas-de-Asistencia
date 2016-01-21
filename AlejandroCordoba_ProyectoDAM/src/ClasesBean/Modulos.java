package ClasesBean;

import java.io.Serializable;

/**
 * 
 * @author Alejandro Cordoba Mu�oz
 *
 */

public class Modulos implements Serializable {

	/**
	 * Declaraci�n de variables
	 */
	private static final long serialVersionUID = 1L;
	private int id_Modulo;
	private String curso;
	private String nombre;
	private String siglas;
	private int horas;
	private int porcentaje;

	public Modulos () {
		
	}

	/**
	 * 
	 * @param id_Modulo, identificador del m�dulo profesional
	 * @param curso, curso del m�dulo profesional
	 * @param nombre, nombre del m�dulo profesional
	 * @param siglas, siglas del m�dulo profesional
	 * @param horas, horas del m�dulo profesional
	 * @param porcentaje, porcentaje del m�dulo profesional
	 */
	public Modulos (int id_Modulo, String curso, String nombre, String siglas, int horas, int porcentaje){
		this.id_Modulo=id_Modulo;
		this.curso=curso;
		this.nombre=nombre;
		this.siglas=siglas;
		this.horas=horas;
		this.porcentaje=porcentaje;
	}
	
	/**
	 * 
	 * @return, devuelve el identificador m�dulo profesional
	 */
	public int getId_Modulo() {
		return id_Modulo;
	}

	/**
	 * 
	 * @param id_Modulo, recibe como parametro el identificador del m�dulo profesional
	 */
	public void setId_Modulo(int id_Modulo) {
		this.id_Modulo = id_Modulo;
	}

	/**
	 * 
	 * @return, devuelve el curso del m�dulo profesional
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * 
	 * @param curso, recibe como parametros el curso del m�dulo profesional
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * 
	 * @return, devuelve el nombre del m�dulo profesional
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre, recibe como parametros el nombre del m�dulo profesional
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return, devuelve las siglas del m�dulo profesional
	 */
	public String getSiglas() {
		return siglas;
	}

	/**
	 * 
	 * @param siglas, recibe como parametros las siglas del m�dulo profesional
	 */
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	/**
	 * 
	 * @return, devuelve las horas del m�dulo profesional
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * 
	 * @param horas, recibe como parametros las horas del m�dulo profesional
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * 
	 * @return, devuelve el porcentaje del m�dulo profesional
	 */
	public int getPorcentaje() {
		return porcentaje;
	}
	
	/**
	 * 
	 * @param porcentaje, recibe como parametro el porcentaje de horas limites de asistencia del m�dulo
	 */
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

}
