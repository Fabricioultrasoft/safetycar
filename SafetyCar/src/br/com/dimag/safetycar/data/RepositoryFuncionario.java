package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryFuncionario;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Funcionario;
import br.com.dimag.safetycar.model.Funcionario.TipoFuncionario;

public class RepositoryFuncionario implements IRepositoryFuncionario {

	private static RepositoryFuncionario instance;	
	
	private Class<Funcionario> clazz = Funcionario.class;
	
	public static RepositoryFuncionario getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryFuncionario) TransactionClass.create(
					RepositoryFuncionario.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Funcionario funcionario) {
		HibernateUtil.getSession().delete(funcionario);
	}

	@Override
	@HibernateTransaction
	public void insert(Funcionario funcionario) {
		HibernateUtil.getSession().save(funcionario);
	}

	@Override
	@HibernateTransaction
	public void update(Funcionario funcionario) {
		HibernateUtil.getSession().merge(funcionario);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Funcionario> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listAtendente() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName() +" f where f.tipoFuncionario = :atendente ").setParameter("atendente", TipoFuncionario.ATENDENTE).list();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listMecanico() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName() +" f where f.tipoFuncionario = :mecanico ").setParameter("mecanico", TipoFuncionario.MECANICO).list();
	}
}
