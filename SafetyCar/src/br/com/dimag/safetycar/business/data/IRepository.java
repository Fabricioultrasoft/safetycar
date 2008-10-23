package br.com.dimag.safetycar.business.data;

import br.com.dimag.safetycar.model.BasicClass;

public interface IRepository<T extends BasicClass> {
	public void insert(T type);
	public void update(T type);
	public void delete(T type);
	

}
