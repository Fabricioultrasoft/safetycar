package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.BaseEntity;

public interface IRepository<T extends BaseEntity> {
	public void insert(T type) throws DataException;
	public void update(T type);
	public void delete(T type);
	public List<T> list();
}
