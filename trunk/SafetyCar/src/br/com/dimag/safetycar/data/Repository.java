package br.com.dimag.safetycar.data;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.model.BaseEntity;

public abstract class Repository<T extends BaseEntity> implements
		IRepository<T> {

	private Class<T> classe;

	protected Repository(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	@HibernateTransaction
	public void delete(T type) {
		HibernateUtil.getSession().delete(type);
	}

	@Override
	@HibernateTransaction
	public void insert(T type) {
		HibernateUtil.getSession().save(type);
	}

	@Override
	@HibernateTransaction
	public void update(T type) {
		HibernateUtil.getSession().merge(type);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<T> list(){
		return HibernateUtil.getSession().createQuery(
				"from " + classe.getClass().getSimpleName()).list();
	}
}