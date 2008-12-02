package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryTipoFuncionario;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.TipoFuncionario;

public class CadastroTipoFuncionario {

	private RepositoryTipoFuncionario repository;

	public CadastroTipoFuncionario() throws Exception {
		repository = RepositoryTipoFuncionario.getInstance();
	}

	public void inserir(TipoFuncionario tipoFuncionario) throws DadosInsuficientesException,
			DataException {
		repository.insert(tipoFuncionario);

	}

	public void atualizar(TipoFuncionario tipoFuncionario) throws DadosInsuficientesException {
		if (tipoFuncionario.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ tipoFuncionario.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(tipoFuncionario);
	}

	public void delete(TipoFuncionario tipoFuncionario) throws DadosInsuficientesException {
		if (tipoFuncionario.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ tipoFuncionario.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(tipoFuncionario);
	}

	public List<TipoFuncionario> list() {
		return repository.list();
	}

}
