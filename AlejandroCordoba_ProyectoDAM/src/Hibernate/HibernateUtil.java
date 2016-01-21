package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

/**
 * 
 * @author Alejandro C�rdoba Mu�oz
 *
 */

public class HibernateUtil {
	/**
	 * Declaraci�n de variables
	 */
	private static SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
	private static Session session;
	private static StandardServiceRegistryBuilder builder;
	
	//M�todo para crear un objeto tipo SessionFactory para poder recibir la conexi�n
	private static void buildSessionFactory(){
		try{
			Configuration configure = new Configuration().configure();
						
			builder = new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
			sessionFactory = configure.buildSessionFactory(builder.build());

		}
		catch (Exception e) {
			logger.error(e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * 
	 * @return, devuelve un objeto SessionFactory
	 */
	//M�todo para devolver el objeto SessionFactory creado en el m�todo anterior
	private static SessionFactory getSessionFactory() {
		buildSessionFactory();
		return sessionFactory;
	}
	
	/**
	 * 
	 * @return, devuelve un objeto Session
	 */
	//M�todo para poder devolver la conexi�n al objeto tipo Session para poder conectarnos
	public static Session getSession(){
		if (session != null && session.isOpen())
			return session;
		else {
			session = getSessionFactory().openSession();
			return session;
		}
	}
	
	
}