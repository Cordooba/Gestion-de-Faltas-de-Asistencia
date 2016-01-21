package Hibernate;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 
 * @author Alejandro Córdoba Muñoz
 *
 */

public class CrearBD {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ProyectoDAM","root","");
			
			//Tabla_Alumno
			String tabla_Alumno = "CREATE TABLE ALUMNOS("
					+ "ID_ALUMNO INTEGER ,"
					+ "CURSO VARCHAR (10),"
					+ "NOMBRE VARCHAR (30),"
					+ "APELLIDO VARCHAR (40),"
					+ "PRIMARY KEY(ID_ALUMNO)"
					+ ");";
			
			//Tabla_Modulos
			String tabla_Modulos = "CREATE TABLE MODULOS("
					+ "ID_MODULO INTEGER ,"
					+ "CURSO VARCHAR (10),"
					+ "NOMBRE VARCHAR (40),"
					+ "SIGLAS VARCHAR (6),"
					+ "HORAS INTEGER (5),"
					+ "PORCENTAJE INTEGER (2),"
					+ "PRIMARY KEY(ID_MODULO)"
					+ ");";
			
			//Tabla_FaltasAsistencia
			String tabla_FaltasAsistencia = "CREATE TABLE FALTAS("
					+ "ID_MODULO INTEGER ,"
					+ "ID_ALUMNO INTEGER ,"
					+ "HORAS INTEGER,"
					+ "PRIMARY KEY(ID_ALUMNO, ID_MODULO)"
					+ ");";

			Statement st = (Statement) cn.createStatement();
			
			st.executeUpdate(tabla_Alumno);
			st.executeUpdate(tabla_Modulos);
			st.executeUpdate(tabla_FaltasAsistencia);
			//Las relaciones se han realizado a través de phpMyAdmin por tanto
			//quedan reflejadas en el fichero .sql exportado en la aplicacion
			cn.close();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
