package br.com.dimag.safetycar.data.transaction;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.Cache;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.engine.SessionFactoryImplementor;

public class HibernateUtil {
	
	private static final SessionFactory factory;

	private static final ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();

	private static final ThreadLocal<Transaction> transactionThread = new ThreadLocal<Transaction>();
	
	static {
		try {
			factory = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void init(){
		
	}

	/**
	 * Should be called to release Hibernate resources
	 */
	public static void releaseResources() {
		factory.close();
	}

	/**
	 * Used to get the session of actual thread
	 * 
	 * @return a session
	 */
	public static Session getSession() {
		if (sessionThread.get() == null) {
			Session session = factory.openSession();
			sessionThread.set(session);
		}
		return (Session) sessionThread.get();
	}

	/**
	 * Used to close the session of the actual thread
	 */
	public static void closeSession() {
		Session session = (Session) sessionThread.get();
		if (session != null && session.isOpen()) {
			sessionThread.set(null);
			session.close();
		}
	}

	/**
	 * Begin a transaction
	 */
	public static void beginTransaction() {
		Transaction transaction = getSession().beginTransaction();
		transactionThread.set(transaction);
	}

	
	/**
	 * Commit a transaction
	 */
	public static void commitTransaction() {
		Transaction transaction = (Transaction) transactionThread.get();
		if (transaction != null && !transaction.wasCommitted()
				&& !transaction.wasRolledBack()) {
			transaction.commit();
			transactionThread.set(null);
		}
	}

	/**
	 * Flush the operations of the actual session
	 */
	public static void flush() {
		Session session = (Session) sessionThread.get();
		if (session != null && session.isOpen()) {
			session.flush();
		}
	}

	/**
	 * Rollback the actual sessions operations
	 */
	public static void rollbackTransaction() {
		Transaction transaction = (Transaction) transactionThread.get();
		if (transaction != null && !transaction.wasCommitted()
				&& !transaction.wasRolledBack()) {
			transaction.rollback();
			transactionThread.set(null);
		}
	}

	/**
	 * Refresh the objects on the cache
	 */
	public static void refresh() {
		Map map = factory.getAllClassMetadata();
		for (Object obj : map.entrySet()) {
			if (obj.getClass().getName().startsWith("br.com.dimag.safetycar")) {
				factory.evict(obj.getClass());
			}
		}
		SessionFactoryImplementor sfi = (SessionFactoryImplementor)factory;   
		Map cacheRegions = sfi.getAllSecondLevelCacheRegions();
		for(Object key:cacheRegions.keySet()){
			((Cache)cacheRegions.get(key)).clear();
		}
	}
}
