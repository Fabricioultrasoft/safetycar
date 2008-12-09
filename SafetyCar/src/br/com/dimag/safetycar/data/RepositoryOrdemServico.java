package br.com.dimag.safetycar.data;

import java.util.ArrayList;
import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryOrdemServico;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.OrdemServico;
import br.com.dimag.safetycar.model.OrdemServicoServico;

public class RepositoryOrdemServico implements IRepositoryOrdemServico {

	private static RepositoryOrdemServico instance;

	private Class<OrdemServico> clazz = OrdemServico.class;

	public static RepositoryOrdemServico getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryOrdemServico) TransactionClass.create(
					RepositoryOrdemServico.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(OrdemServico ordemServico) {
		HibernateUtil.getSession().delete(ordemServico);
	}

	@Override
	@HibernateTransaction
	public void insert(OrdemServico ordemServico) {
		HibernateUtil.getSession().save(ordemServico);
	}

	@Override
	@HibernateTransaction
	public void update(OrdemServico ordemServico) {
		HibernateUtil.getSession().update(ordemServico);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<OrdemServico> list() {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}
	
	@Override
	@HibernateTransaction
	public List<Automovel> listAutomovel(Cliente cliente){
		List<Automovel> listAutomovel = new ArrayList<Automovel>();
		List<OrdemServico> list = HibernateUtil.getSession().createQuery("from OrdemServico os where os.cliente.id= :clienteId").setParameter("clienteId", cliente.getId()).list();
		for (OrdemServico ordemServico: list){
			listAutomovel.add(ordemServico.getAutomovel());
		}
		return listAutomovel; 
	}

	public List<OrdemServicoServico> listOrdemServicoServico(OrdemServico os) {

		return HibernateUtil.getSession().createQuery("from OrdemServicoServico oss where oss.ordemServico.id = :osId").setParameter("osId", os.getId()).list();
		
	}
}