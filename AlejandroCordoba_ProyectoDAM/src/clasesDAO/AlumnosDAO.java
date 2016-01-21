package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import Hibernate.HibernateUtil;
import ClasesBean.Alumnos;

/**
 * 
 * @author Alejandro Cordoba Muñoz
 *
 */

public class AlumnosDAO {
	//Obtenemos la session, en caso de que no se haya creado antés
	Session session = HibernateUtil.getSession();

	/**
	 * 
	 * @param alumno, recibe como parametros un alumno
	 */
	//Método que no devuelve nada, y es empleado para poder registrar un registro en la base de datos
	public void registrar(Alumnos alumno){
		session.save(alumno);
	}
	
	/**
	 * 
	 * @param alumno, recibe como parametros un alumno
	 */
	//Método que no devuelve nada, y es empleado para poder borrar un registro en la base de datos
	public void borrar(Alumnos alumno){
		session.delete(alumno);
	}
	
//	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @return, devuelve una lista con todos los alumnos
	 */
	//Método que devuelve un objeto tipo List para obtener todos los registros de la base de datos
	public List <Alumnos> listarTodos (){
		
		List <Alumnos> alumnos = new ArrayList<Alumnos>();
		alumnos = session.createQuery("select a from Alumnos a").list();
		
		return alumnos;
	}
	
	/**
	 * 
	 * @param id_alumno, recibe como parametros el identificador de un alumno
	 * @return, devuelve un alumno 
	 */
	//Método que devuelve un objeto Alumnos, buscado a través del campo ID_ALUMNO
	public Alumnos buscarId (int id_alumno){
		Alumnos alumnos = (Alumnos) session.createQuery("select a from Alumnos a where ID_ALUMNO=:id").setParameter("id", id_alumno).uniqueResult();
		return alumnos;
	}
	
	/**
	 * 
	 * @param curso, recibe como parametros el curso del alumnos
	 * @return, devuelve una lista de alumnos de un determinado curso
	 */
	@SuppressWarnings("unchecked")
	//Método que devuelve un objeto tipo List de Alumnos de un determinado curso
	public List <Alumnos> buscarPorCurso (String curso){
		List <Alumnos> alumnos = new ArrayList<Alumnos>();
		alumnos = session.createQuery("select a from Alumnos a where CURSO=:curso").setParameter("curso", curso).list(); 
		return alumnos;
	}
	
}
