package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import Hibernate.HibernateUtil;
import ClasesBean.Faltas;

/**
 * 
 * @author Alejabdro Cordoba Muñoz
 *
 */

public class FaltasDAO {
	//Obtenemos la session, en caso de que no se haya creado antés
	Session session = HibernateUtil.getSession();
	
	/**
	 * 
	 * @param faltas, recibe como parametros una falta de asistencia
	 */
	//Método que no devuelve nada, y es empleado para poder registrar un registro en la base de datos
	public void registrar(Faltas faltas){
		session.save(faltas);
	}
	
	/**
	 * 
	 * @param faltas, recibe como parametros una falta de asistencia
	 */
	//Método que no devuelve nada, y es empleado para poder borrar un registro en la base de datos
	public void borrar(Faltas faltas){
		session.delete(faltas);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @return, devuelve todas las faltas de asistencia
	 */
	//Método que devuelve un objeto tipo List para obtener todos los registros de la base de datos
	public List <Faltas> listarTodos (){
		Session session = HibernateUtil.getSession();
		
		List <Faltas> faltas = new ArrayList<Faltas>();
		faltas = session.createQuery("select a from Faltas a").list();
		
		return faltas;
	}
	
	/**
	 * 
	 * @param id_alumno, recibe como parametros el identificador del alumno
	 * @return, devuevle un objeto de tipo Faltas
	 */
	//Método que devuelve un objeto tipo Faltas a través del campo ID_ALUMNO
	public Faltas buscarFaltasPorId_Alumno(int id_alumno){
		Faltas faltas = (Faltas) session.createQuery("select m from Faltas m where ID_ALUMNO=:id").setParameter("id", id_alumno).uniqueResult();
		return faltas;
	}
	
	/**
	 * 
	 * @param id_modulo, recibe como parametros el identificador del modulo
	 * @return, devuevle un objeto de tipo Faltas
	 */
	//Método que devuelve un objeto tipo Faltas a través del campo ID_MODULO
	public Faltas buscarFaltasporId_Modulo (int id_modulo){
		Faltas faltas = (Faltas) session.createQuery("select f from Faltas f where ID_MODULO=:id").setParameter("id", id_modulo).uniqueResult();
		return faltas;
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param id_modulo, recibe como parametros el identificador del modulo
	 * @return, devuevle un objeto de tipo List <Faltas>
	 */
	//Método que devuelve un objeto tipo Faltas a través del campo ID_ALUMNO
	public List <Faltas> buscarFaltasModulos (int id_modulo){
		List <Faltas> faltas = (List<Faltas>) session.createQuery("select m from Faltas m where ID_MODULO=:id").setParameter("id", id_modulo).list();
		return faltas;
	}
	
	/**
	 * 
	 * @param id_alumno, recibe como parametros el identificador del alumno
	 * @param id_modulo, recibe como parametros el identificador del modulo
	 * @return, devuevle un objeto de tipo Faltas
	 */
	//Método que devuelve un objeto tipo Faltas a través del campo ID_MODULO y ID_ALUMNO
	public Faltas buscarFaltasPorIdentificadores (int id_alumno, int id_modulo){
		Faltas faltas = (Faltas) session.createQuery("select m from Faltas m where ID_ALUMNO=:id_alumno AND ID_MODULO=:id_modulo").setParameter("id_alumno", id_alumno).setParameter("id_modulo", id_modulo).uniqueResult();
		return faltas;
	}
}
