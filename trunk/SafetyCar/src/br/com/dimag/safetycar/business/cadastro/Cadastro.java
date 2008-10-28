package br.com.dimag.safetycar.business.cadastro;

import br.com.dimag.safetycar.data.IRepository;
import br.com.dimag.safetycar.model.BasicClass;

public abstract class Cadastro<T extends BasicClass> {
	
	private IRepository<T> repository;
	
	protected Cadastro(IRepository<T> repository){
		this.repository = repository;
	}
	
	public void inserir(T type) throws DadosInsuficientesException{
		if (type.getId() == null){
			throw new DadosInsuficientesException("O Objeto "+ type.getClass().getSimpleName() +" não possui ID.");
		}	
		repository.insert(type);
		
	}
	
	public void atualizar(T type) throws DadosInsuficientesException{
		if (type.getId() == null){
			throw new DadosInsuficientesException("O Objeto "+ type.getClass().getSimpleName() +" não possui ID.");
		}
		repository.update(type);
	}

	public void delete(T type) throws DadosInsuficientesException{
		if (type.getId() == null){
			throw new DadosInsuficientesException("O Objeto "+ type.getClass().getSimpleName() +" não possui ID.");
		}
		repository.delete(type);
	}
	
}
