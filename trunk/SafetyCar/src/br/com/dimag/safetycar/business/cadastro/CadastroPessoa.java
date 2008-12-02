package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryPessoa;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Pessoa;

public class CadastroPessoa {

	private RepositoryPessoa repository;

	public CadastroPessoa() throws Exception {
		repository = RepositoryPessoa.getInstance();
	}

	public void inserir(Pessoa pessoa) throws DadosInsuficientesException,
			DataException {
		repository.insert(pessoa);

	}

	public void atualizar(Pessoa pessoa) throws DadosInsuficientesException {
		if (pessoa.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ pessoa.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(pessoa);
	}

	public void delete(Pessoa pessoa) throws DadosInsuficientesException {
		if (pessoa.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ pessoa.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(pessoa);
	}

	public List<Pessoa> list() {
		return repository.list();
	}

}
