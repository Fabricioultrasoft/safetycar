package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryPessoa;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Pessoa;

public class RepositoryPessoa implements IRepositoryPessoa {

	private static RepositoryPessoa instance;	
	
	private Class<Pessoa> clazz = Pessoa.class;
	
	public static RepositoryPessoa getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryPessoa) TransactionClass.create(
					RepositoryPessoa.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Pessoa pessoa) {
		HibernateUtil.getSession().delete(pessoa);
	}

	@Override
	@HibernateTransaction
	public void insert(Pessoa pessoa) {
		HibernateUtil.getSession().save(pessoa);
	}

	@Override
	@HibernateTransaction
	public void update(Pessoa pessoa) {
		HibernateUtil.getSession().merge(pessoa);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Pessoa> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
}
