package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.model.BaseEntity;


public class Repository<T extends BaseEntity> implements IRepository<T> {

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
		

	}

	@Override
	public void update(T type) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
