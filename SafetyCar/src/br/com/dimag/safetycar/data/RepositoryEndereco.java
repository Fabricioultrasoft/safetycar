package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryEndereco;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Endereco;

public class RepositoryEndereco implements IRepositoryEndereco {

	private static RepositoryEndereco instance;	
	
	private Class<Endereco> clazz = Endereco.class;
	
	public static RepositoryEndereco getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryEndereco) TransactionClass.create(
					RepositoryEndereco.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Endereco endereco) {
		HibernateUtil.getSession().delete(endereco);
	}

	@Override
	@HibernateTransaction
	public void insert(Endereco endereco) {
		HibernateUtil.getSession().save(endereco);
	}

	@Override
	@HibernateTransaction
	public void update(Endereco endereco) {
		HibernateUtil.getSession().merge(endereco);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Endereco> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
	
	public Endereco findEnderecoBaseByCep(String cep) {
		return (Endereco) HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()+" e where e.cep = :cep").setParameter("cep", cep).uniqueResult();
	}
}
