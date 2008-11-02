package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryCliente;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Cliente;

public class CadastroCliente {

	private RepositoryCliente repository;

	public CadastroCliente() throws Exception {
		repository = RepositoryCliente.getInstance();
	}

	public void inserir(Cliente type) throws DadosInsuficientesException,
			DataException {
		repository.insert(type);

	}

	public void atualizar(Cliente type) throws DadosInsuficientesException {
		if (type.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ type.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(type);
	}

	public void delete(Cliente type) throws DadosInsuficientesException {
		if (type.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ type.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(type);
	}

	public List<Cliente> list() {
		return repository.list();
	}
}
