package br.com.dimag.safetycar.business;

import java.util.List;

import br.com.dimag.safetycar.data.IRepositoryCliente;
import br.com.dimag.safetycar.data.RepositoryCliente;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Cliente;

public class CadastroCliente {
	
	private IRepositoryCliente repository;
	
	public CadastroCliente () throws DataException{
		RepositoryCliente.getInstance();
	}
	
	public void inserir(Cliente cliente) throws DadosInsuficientesException, DataException{
		repository.insert(cliente);
	}
	
	public void atualizar(Cliente cliente) throws DadosInsuficientesException{
		if (cliente.getId() == null){
			throw new DadosInsuficientesException("O Objeto "+ cliente.getClass().getSimpleName() +" não possui ID.");
		}
		repository.update(cliente);
	}

	public void delete(Cliente cliente) throws DadosInsuficientesException{
		if (cliente.getId() == null){
			throw new DadosInsuficientesException("O Objeto "+ cliente.getClass().getSimpleName() +" não possui ID.");
		}
		repository.delete(cliente);
	}
	
	public List<Cliente> list() {
		return repository.list();
	}
}
