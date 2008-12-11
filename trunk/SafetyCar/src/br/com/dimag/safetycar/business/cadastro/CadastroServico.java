package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryServico;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Servico;

public class CadastroServico {

	private RepositoryServico repository;

	public CadastroServico() throws Exception {
		repository = RepositoryServico.getInstance();
	}

	public void inserir(Servico servico) throws DadosInsuficientesException,
			DataException {
		repository.insert(servico);

	}

	public void atualizar(Servico servico) throws DadosInsuficientesException {
		if (servico.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ servico.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(servico);
	}

	public void delete(Servico servico) throws DadosInsuficientesException {
		if (servico.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ servico.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(servico);
	}

	public List<Servico> list() {
		return repository.list();
	}

	public List<Servico> searchListServicoByDescricao(String descricao) {
		return repository.searchListServicoByDescricao(descricao);
	}

}
