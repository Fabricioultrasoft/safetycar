package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryAutomovel;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Automovel;

public class RepositoryAutomovel implements IRepositoryAutomovel {

	private static RepositoryAutomovel instance;	
	
	private Class<Automovel> clazz = Automovel.class;
	
	public static RepositoryAutomovel getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryAutomovel) TransactionClass.create(
					RepositoryAutomovel.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Automovel automovel) {
		HibernateUtil.getSession().delete(automovel);
	}

	@Override
	@HibernateTransaction
	public void insert(Automovel automovel) {
		HibernateUtil.getSession().save(automovel);
	}

	@Override
	@HibernateTransaction
	public void update(Automovel automovel) {
		HibernateUtil.getSession().update(automovel);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Automovel> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
}
