
package br.com.dimag.safetycar.data.transaction;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 * Proxy class to intercept all method calls to the implementations of
 * GenericDao
 */
public abstract class HibernateInterceptor implements MethodInterceptor {

	/*
	 * Implementation of method interception (non-Javadoc)
	 * 
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object,
	 *      java.lang.reflect.Method, java.lang.Object[],
	 *      net.sf.cglib.proxy.MethodProxy)
	 */
	public Object intercept(Object object, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		Object result = null;
		
		boolean isTransactional = isTransactional(object, method);
		if (isTransactional) {
			HibernateUtil.beginTransaction();
		}
		try {
			result = methodProxy.invokeSuper(object, args);
			if (isTransactional) {
				HibernateUtil.flush();
				HibernateUtil.commitTransaction();
			}
		} catch (Exception e) {
			for (Object obj : args) {
				System.out.println("obj:" + obj);
			}
			if (isTransactional) {
				HibernateUtil.rollbackTransaction();
			}
			throw e;
		} finally {
			HibernateUtil.closeSession();
		}
		return result;
	}

	/**
	 * Verfies if an intercepted method is transactional to be implemented on
	 * the subclass of HibernateInterceptor
	 * 
	 * @param object
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public abstract boolean isTransactional(Object object, Method method)
			throws Exception;
}
