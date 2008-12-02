package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryFornecedor;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Fornecedor;

public class RepositoryFornecedor implements IRepositoryFornecedor {

	private static RepositoryFornecedor instance;	
	
	private Class<Fornecedor> clazz = Fornecedor.class;
	
	public static RepositoryFornecedor getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryFornecedor) TransactionClass.create(
					RepositoryFornecedor.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Fornecedor fornecedor) {
		HibernateUtil.getSession().delete(fornecedor);
	}

	@Override
	@HibernateTransaction
	public void insert(Fornecedor fornecedor) {
		HibernateUtil.getSession().save(fornecedor);
	}

	@Override
	@HibernateTransaction
	public void update(Fornecedor fornecedor) {
		HibernateUtil.getSession().merge(fornecedor);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Fornecedor> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
}
