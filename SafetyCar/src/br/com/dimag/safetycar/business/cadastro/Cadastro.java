package br.com.dimag.safetycar.business.cadastro;

import br.com.dimag.safetycar.data.IRepository;
import br.com.dimag.safetycar.model.BasicClass;

public class Cadastro<T extends BasicClass> {
	
	IRepository<T> repository;
	
	public Cadastro(IRepository<T> repository){
		this.repository = repository;
	}
	
	public void inserir(T type){
		repository.insert(type);
	}
	
	public void atualizar(T type){
		repository.update(type);
	}

	public void delete(T type){
		repository.delete(type);
	}
	
}
