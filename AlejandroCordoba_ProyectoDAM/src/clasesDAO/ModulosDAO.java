package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ClasesBean.Modulos;
import Hibernate.HibernateUtil;

/**
 * 
 * @author Alejandro Cordoba Muñoz
 *
 */

public class ModulosDAO {
	//Obtenemos la session, en caso de que no se haya creado antés
	Session session = HibernateUtil.getSession();

	/**
	 * 
	 * @param modulo, recibe como parametros un módulo profesional
	 */
	//Método que no devuelve nada, y es empleado para poder registrar un registro en la base de datos
	public void registrar(Modulos modulo){
		Session session = HibernateUtil.getSession();
		session.save(modulo);
	}
	
	/**
	 * 
	 * @param modulo, recibe como parametros un módulo profesional
	 */
	//Método que no devuelve nada, y es empleado para poder borrar un registro en la base de datos
	public void borrar(Modulos modulo){
		Session session = HibernateUtil.getSession();
		session.delete(modulo);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @return, devuelve todos los módulos profesionales
	 */
	//Método que devuelve un objeto tipo List para obtener todos los registros de la base de datos
	public List <Modulos> listarTodos (){
		Session session = HibernateUtil.getSession();
		
		List <Modulos> modulos = new ArrayList<Modulos>();
		modulos = session.createQuery("select a from Modulos a").list();
		
		return modulos;
	}
	
	/**
	 * 
	 * @param id_modulo, recibe como parametros el identificador de un módulo profesional
	 * @return, devuelve un módulo profesional
	 */
	//Método que devuelve un objeto tipo Modulos a través del campo ID_MODULO
	public Modulos buscarModuloPorId(int id_modulo){
		Modulos modulos = (Modulos) session.createQuery("select m from Modulos m where ID_MODULO=:id").setParameter("id", id_modulo).uniqueResult();
		return modulos;
	}
}
