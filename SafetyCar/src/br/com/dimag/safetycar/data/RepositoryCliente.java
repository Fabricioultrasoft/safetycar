package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryCliente;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Cliente;

public abstract class RepositoryCliente implements IRepositoryCliente {

	private static RepositoryCliente instance;

	private Class<Cliente> clazz = Cliente.class;

	public static RepositoryCliente getInstance() throws DataException {
		if (instance == null) {
			try {
				instance = (RepositoryCliente) TransactionClass.create(
						RepositoryCliente.class,
						HibernateInterceptorAnnotation.class);
			} catch (Exception e) {
				throw new DataException(e);
			}
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Cliente cliente) {
		HibernateUtil.getSession().delete(cliente);
	}

	@Override
	@HibernateTransaction
	public void insert(Cliente cliente) {
		HibernateUtil.getSession().save(cliente);
	}

	@Override
	@HibernateTransaction
	public void update(Cliente cliente) {
		HibernateUtil.getSession().update(cliente);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Cliente> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
}