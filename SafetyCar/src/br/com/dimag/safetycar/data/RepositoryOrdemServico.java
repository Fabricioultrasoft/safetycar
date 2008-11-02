package br.com.dimag.safetycar.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.OrdemServico;

public class RepositoryOrdemServico extends Repository<OrdemServico> {

	private static RepositoryOrdemServico instance;	
	
	public static RepositoryOrdemServico getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryOrdemServico) TransactionClass.create(
					RepositoryOrdemServico.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	
	protected RepositoryOrdemServico() {
		super(OrdemServico.class);
	}
	
	public List<Automovel> listAutomovel(Cliente cliente){
		List<Automovel> listAutomovel = new ArrayList<Automovel>();
		List<OrdemServico> list = HibernateUtil.getSession().createQuery("from OrdemServico os where os.cliente.id= :clienteId").setParameter("clienteId", cliente.getId()).list();
		for (OrdemServico ordemServico: list){
			listAutomovel.add(ordemServico.getAutomovel());
		}
		return listAutomovel; 
	}
	
	
}
