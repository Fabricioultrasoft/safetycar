package br.com.dimag.safetycar.data;

import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.model.Automovel;

public class RepositoryAutomovel extends Repository<Automovel> {

	private static RepositoryAutomovel instance;	
	
	public static RepositoryAutomovel getInstance() throws Exception {
		if (instance == null) {
			instance = (RepositoryAutomovel) TransactionClass.create(
					RepositoryAutomovel.class,
					HibernateInterceptorAnnotation.class);
		}
		return instance;
	}

	
	protected RepositoryAutomovel() {
		super(Automovel.class);
	}
}
