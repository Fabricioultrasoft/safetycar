package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryEnderecoBase;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.EnderecoBase;

public class CadastroEnderecoBase {

	private RepositoryEnderecoBase repository;

	public CadastroEnderecoBase() throws Exception {
		repository = RepositoryEnderecoBase.getInstance();
	}

	public void inserir(EnderecoBase endereco) throws DadosInsuficientesException,
			DataException {
		repository.insert(endereco);

	}

	public void atualizar(EnderecoBase endereco) throws DadosInsuficientesException {
		if (endereco.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ endereco.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(endereco);
	}

	public void delete(EnderecoBase endereco) throws DadosInsuficientesException {
		if (endereco.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ endereco.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(endereco);
	}

	public List<EnderecoBase> list() {
		return repository.list();
	}

	public EnderecoBase findEnderecoBaseByCep(String cep) {
		return repository.findEnderecoBaseByCep(cep);
	}

}