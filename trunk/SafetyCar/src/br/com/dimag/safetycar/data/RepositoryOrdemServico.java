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
	@SuppressWarnings("unchecked")
	public List<Automovel> listAutomovel(Cliente cliente){
		List<Automovel> listAutomovel = new ArrayList<Automovel>();
		List<OrdemServico> list = HibernateUtil.getSession().createQuery("from OrdemServico os where os.cliente.id= :clienteId").setParameter("clienteId", cliente.getId()).list();
		for (OrdemServico ordemServico: list){
			listAutomovel.add(ordemServico.getAutomovel());
		}
		return listAutomovel; 
	}

	@SuppressWarnings("unchecked")
	public List<OrdemServico> searchListServicoByDescricao(String placa) {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName() +" s where s.placa like lower( :placa ) " ).setParameter("placa", "%"+placa.toLowerCase()+"%" ).list();
	}

}
