package br.com.dimag.safetycar.data;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Cliente;

public class RepositoryCliente extends Repository<Cliente> {

private static RepositoryCliente instance;
	
	public static RepositoryCliente getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryCliente) TransactionClass.create(
					RepositoryCliente.class,
					HibernateInterceptorAnnotation.class);
		}
		Type type;
		
		return instance;
	}
}
