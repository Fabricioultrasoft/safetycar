package br.com.dimag.safetycar.business.data;

import br.com.dimag.safetycar.model.Cliente;

public class FactoryRepository {
	
	private static FactoryRepository factory;

	public static FactoryRepository getIntance() {
		if (factory == null){
			factory = new FactoryRepository();
		}
		return factory;
	}

	public Repository<Cliente> getRepositoryCliente(){
		return new RepositoryCliente();
	}
	
}
