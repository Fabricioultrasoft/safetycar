package br.com.dimag.safetycar.data;

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
		return instance;
	}

	protected RepositoryCliente() {
		super(Cliente.class);
	}

}
