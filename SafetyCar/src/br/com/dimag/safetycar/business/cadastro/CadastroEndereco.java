package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryEndereco;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Endereco;

public class CadastroEndereco {

	private RepositoryEndereco repository;

	public CadastroEndereco() throws Exception {
		repository = RepositoryEndereco.getInstance();
	}

	public void inserir(Endereco endereco) throws DadosInsuficientesException,
			DataException {
		repository.insert(endereco);

	}

	public void atualizar(Endereco endereco) throws DadosInsuficientesException {
		if (endereco.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ endereco.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(endereco);
	}

	public void delete(Endereco endereco) throws DadosInsuficientesException {
		if (endereco.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ endereco.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(endereco);
	}

	public List<Endereco> list() {
		return repository.list();
	}

	public Endereco findEnderecoBaseByCep(String cep) {
		return repository.findEnderecoBaseByCep(cep);
	}

}