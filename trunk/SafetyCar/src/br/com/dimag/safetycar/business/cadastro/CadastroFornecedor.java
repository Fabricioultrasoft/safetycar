package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryFornecedor;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Fornecedor;

public class CadastroFornecedor {

	private RepositoryFornecedor repository;

	public CadastroFornecedor() throws Exception {
		repository = RepositoryFornecedor.getInstance();
	}

	public void inserir(Fornecedor fornecedor) throws DadosInsuficientesException,
			DataException {
		repository.insert(fornecedor);

	}

	public void atualizar(Fornecedor fornecedor) throws DadosInsuficientesException {
		if (fornecedor.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ fornecedor.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(fornecedor);
	}

	public void delete(Fornecedor fornecedor) throws DadosInsuficientesException {
		if (fornecedor.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ fornecedor.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(fornecedor);
	}

	public List<Fornecedor> list() {
		return repository.list();
	}

}