package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryOrdemServico;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.OrdemServico;

public class CadastroOrdemServico {

	private RepositoryOrdemServico repository;

	public CadastroOrdemServico() throws Exception {
		repository = RepositoryOrdemServico.getInstance();
	}

	public void inserir(OrdemServico type) throws DadosInsuficientesException,
			DataException {
		repository.insert(type);
	}

	public void atualizar(OrdemServico type) throws DadosInsuficientesException {
		if (type.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ type.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(type);
	}

	public void delete(OrdemServico type) throws DadosInsuficientesException {
		if (type.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ type.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(type);
	}

	public List<OrdemServico> list() {
		return repository.list();
	}

	public List<Automovel> listAutomovel(Cliente cliente) {
		return repository.listAutomovel(cliente);
	}

	public List<OrdemServico> searchListServicoByDescricao(String placa) {
		return repository.searchListServicoByDescricao(placa);
	}

}
