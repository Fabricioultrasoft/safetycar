package br.com.dimag.safetycar.business.data;

import br.com.dimag.safetycar.model.BasicClass;

public class Repository<T extends BasicClass> implements IRepository<T> {

	private Class<T> classe;

	public Repository(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void delete(T type){ 
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(T type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(T type) {
		// TODO Auto-generated method stub

	}

}
