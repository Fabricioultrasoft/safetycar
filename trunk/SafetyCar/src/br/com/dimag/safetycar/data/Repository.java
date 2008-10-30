package br.com.dimag.safetycar.data;

import java.util.List;

import org.hibernate.Session;

import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.BaseEntity;

public abstract class Repository<T extends BaseEntity> implements
		IRepository<T> {

	private Class<T> classe;

	public Repository(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void delete(T type) {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.delete(type);

		session.getTransaction().commit();

	}

	@Override
	public void insert(T type) throws DataException {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			session.save(type);

			session.getTransaction().commit();
		}catch (Exception e) {
			throw new DataException(e);
		}

	}

	@Override
	public void update(T type) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.merge(type);

		session.getTransaction().commit();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> list() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		List list = session.createQuery("from " + classe.getSimpleName())
				.list();

		session.getTransaction().commit();
		return list;
	}
}