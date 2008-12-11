package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryEnderecoBase;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.EnderecoBase;

public class RepositoryEnderecoBase implements IRepositoryEnderecoBase {

	private static RepositoryEnderecoBase instance;	
	
	private Class<EnderecoBase> clazz = EnderecoBase.class;
	
	public static RepositoryEnderecoBase getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryEnderecoBase) TransactionClass.create(
					RepositoryEnderecoBase.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(EnderecoBase endereco) {
		HibernateUtil.getSession().delete(endereco);
	}

	@Override
	@HibernateTransaction
	public void insert(EnderecoBase endereco) {
		HibernateUtil.getSession().save(endereco);
	}

	@Override
	@HibernateTransaction
	public void update(EnderecoBase endereco) {
		HibernateUtil.getSession().merge(endereco);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<EnderecoBase> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}

	public EnderecoBase findEnderecoBaseByCep(String cep) {
		return (EnderecoBase) HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()+" e where e.cep = :cep").setParameter("cep", cep).uniqueResult();
	}
}
