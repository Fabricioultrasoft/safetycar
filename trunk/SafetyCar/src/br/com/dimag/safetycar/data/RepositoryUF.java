package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryUF;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.UF;

public class RepositoryUF implements IRepositoryUF {

	private static RepositoryUF instance;	
	
	private Class<UF> clazz = UF.class;
	
	public static RepositoryUF getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryUF) TransactionClass.create(
					RepositoryUF.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(UF uf) {
		HibernateUtil.getSession().delete(uf);
	}

	@Override
	@HibernateTransaction
	public void insert(UF uf) {
		HibernateUtil.getSession().save(uf);
	}

	@Override
	@HibernateTransaction
	public void update(UF uf) {
		HibernateUtil.getSession().merge(uf);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<UF> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
}
