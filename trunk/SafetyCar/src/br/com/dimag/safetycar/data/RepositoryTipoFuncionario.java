package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryTipoFuncionario;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.TipoFuncionario;

public class RepositoryTipoFuncionario implements IRepositoryTipoFuncionario {

	private static RepositoryTipoFuncionario instance;	
	
	private Class<TipoFuncionario> clazz = TipoFuncionario.class;
	
	public static RepositoryTipoFuncionario getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryTipoFuncionario) TransactionClass.create(
					RepositoryTipoFuncionario.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(TipoFuncionario tipoFuncionario) {
		HibernateUtil.getSession().delete(tipoFuncionario);
	}

	@Override
	@HibernateTransaction
	public void insert(TipoFuncionario tipoFuncionario) {
		HibernateUtil.getSession().save(tipoFuncionario);
	}

	@Override
	@HibernateTransaction
	public void update(TipoFuncionario tipoFuncionario) {
		HibernateUtil.getSession().merge(tipoFuncionario);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<TipoFuncionario> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
}
