package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ClasesBean.Modulos;
import Hibernate.HibernateUtil;

/**
 * 
 * @author Alejandro Cordoba Mu�oz
 *
 */

public class ModulosDAO {
	//Obtenemos la session, en caso de que no se haya creado ant�s
	Session session = HibernateUtil.getSession();

	/**
	 * 
	 * @param modulo, recibe como parametros un m�dulo profesional
	 */
	//M�todo que no devuelve nada, y es empleado para poder registrar un registro en la base de datos
	public void registrar(Modulos modulo){
		Session session = HibernateUtil.getSession();
		session.save(modulo);
	}
	
	/**
	 * 
	 * @param modulo, recibe como parametros un m�dulo profesional
	 */
	//M�todo que no devuelve nada, y es empleado para poder borrar un registro en la base de datos
	public void borrar(Modulos modulo){
		Session session = HibernateUtil.getSession();
		session.delete(modulo);
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @return, devuelve todos los m�dulos profesionales
	 */
	//M�todo que devuelve un objeto tipo List para obtener todos los registros de la base de datos
	public List <Modulos> listarTodos (){
		Session session = HibernateUtil.getSession();
		
		List <Modulos> modulos = new ArrayList<Modulos>();
		modulos = session.createQuery("select a from Modulos a").list();
		
		return modulos;
	}
	
	/**
	 * 
	 * @param id_modulo, recibe como parametros el identificador de un m�dulo profesional
	 * @return, devuelve un m�dulo profesional
	 */
	//M�todo que devuelve un objeto tipo Modulos a trav�s del campo ID_MODULO
	public Modulos buscarModuloPorId(int id_modulo){
		Modulos modulos = (Modulos) session.createQuery("select m from Modulos m where ID_MODULO=:id").setParameter("id", id_modulo).uniqueResult();
		return modulos;
	}
}
