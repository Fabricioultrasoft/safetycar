package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryAutomovel;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Automovel;

public class CadastroAutomovel {

	private RepositoryAutomovel repository;

	public CadastroAutomovel() throws Exception {
		repository = RepositoryAutomovel.getInstance();
	}

	public void inserir(Automovel automovel) throws DadosInsuficientesException,
			DataException {
		repository.insert(automovel);

	}

	public void atualizar(Automovel automovel) throws DadosInsuficientesException {
		if (automovel.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ automovel.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(automovel);
	}

	public void delete(Automovel automovel) throws DadosInsuficientesException {
		if (automovel.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ automovel.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(automovel);
	}

	public List<Automovel> list() {
		return repository.list();
	}

}
