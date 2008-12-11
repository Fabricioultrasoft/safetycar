package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryServico;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Servico;

public class RepositoryServico implements IRepositoryServico {

	private static RepositoryServico instance;	
	
	private Class<Servico> clazz = Servico.class;
	
	public static RepositoryServico getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryServico) TransactionClass.create(
					RepositoryServico.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Servico servico) {
		HibernateUtil.getSession().delete(servico);
	}

	@Override
	@HibernateTransaction
	public void insert(Servico servico) {
		HibernateUtil.getSession().save(servico);
	}

	@Override
	@HibernateTransaction
	public void update(Servico servico) {
		HibernateUtil.getSession().merge(servico);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Servico> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}

	@SuppressWarnings("unchecked")
	public List<Servico> searchListServicoByDescricao(String descricao) {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName() +" s where s.descricao like lower( :descricao ) " ).setParameter("descricao", "%"+descricao.toLowerCase()+"%" ).list();
	}
}
