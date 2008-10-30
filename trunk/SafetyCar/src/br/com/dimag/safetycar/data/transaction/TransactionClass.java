
package br.com.dimag.safetycar.data.transaction;


import net.sf.cglib.proxy.Enhancer;

/**
 * This is a proxy class that should be used by the classes that uses HibernateInterceptor
 *
 * @param <T>
 */
public class TransactionClass<T> {
	
	/**
	 * Create an instance of the class that uses HibernateInterceptor
	 * @param beanClass
	 * @param interceptorClass
	 * @return
	 * @throws Exception
	 */
	public static Object create(Class beanClass, Class interceptorClass)
			throws Exception {
		HibernateInterceptor interceptor = (HibernateInterceptor) interceptorClass
				.newInstance();
		Object object = Enhancer.create(beanClass, interceptor);
		return object;
	}
}