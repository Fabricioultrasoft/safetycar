package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryProduto;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Produto;

public class RepositoryProduto implements IRepositoryProduto {

	private static RepositoryProduto instance;	
	
	private Class<Produto> clazz = Produto.class;
	
	public static RepositoryProduto getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryProduto) TransactionClass.create(
					RepositoryProduto.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Produto produto) {
		HibernateUtil.getSession().delete(produto);
	}

	@Override
	@HibernateTransaction
	public void insert(Produto produto) {
		HibernateUtil.getSession().save(produto);
	}

	@Override
	@HibernateTransaction
	public void update(Produto produto) {
		HibernateUtil.getSession().merge(produto);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Produto> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
}
