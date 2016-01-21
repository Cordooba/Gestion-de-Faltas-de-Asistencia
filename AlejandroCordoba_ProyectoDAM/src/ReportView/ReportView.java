package ReportView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @author Alejandro Cordoba Muñoz
 *
 */

public class ReportView {
	/**
	 * 
	 * @param archivo, arhivo o nombre del archivo
	 * @param urixml, ruta archivo XML
	 * @param xpath, ruta xpath
	 * @param parametros, parametros del informe
	 */
	//Metodo para abrir un informe mediante un archivo XML
	public void abrirReportXML (String archivo, String urixml, String xpath, HashMap <String,Object> parametros){
		try {
			//Con esto cargamos el jasper
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(archivo);
			//Parámetros que va a recibir el report

			//Creamos la fuente de datos
			JRXmlDataSource xmlDataSource = new JRXmlDataSource(urixml, xpath);		
			//Rellena lo que va a pintar
			JasperPrint print = JasperFillManager.fillReport(report, parametros, xmlDataSource);
			//Abre el visor con el report
			JasperViewer.viewReport(print, false);
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param archivo, archivo o nombre del informe
	 * @param parametros, parametros que recibe informe
	 */
	//Metodo para abrir un informe sin conexion
	public void abrirReportSinConexion (String archivo, HashMap <String,Object> parametros){
		try {
			//Con esto cargamos el jasper
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(archivo);
			//Rellena lo que va a pintar
			JasperPrint print = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
			//Abre el visor con el report
			JasperViewer.viewReport(print, false);
		} catch (JRException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param archivo, nombre del archivo del informe
	 * @param nombreBD, nombre de la base de datos
	 * @param parametros, parametros del informe
	 */
	//Método para abrir un informe mediante una base de datos
	public void abrirReportBD (String archivo, String nombreBD, HashMap <String,Object> parametros){
		try {
			//Con esto cargamos el jasper
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(archivo);
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/proyectodam", "root", "");
			//Rellena lo que va a pintar
			JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);
			//Abre el visor con el report
			JasperViewer.viewReport(print, false);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
