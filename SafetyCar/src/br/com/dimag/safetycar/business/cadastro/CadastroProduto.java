package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryProduto;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Produto;

public class CadastroProduto {

	private RepositoryProduto repository;

	public CadastroProduto() throws Exception {
		repository = RepositoryProduto.getInstance();
	}

	public void inserir(Produto produto) throws DadosInsuficientesException,
			DataException {
		repository.insert(produto);

	}

	public void atualizar(Produto produto) throws DadosInsuficientesException {
		if (produto.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ produto.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(produto);
	}

	public void delete(Produto produto) throws DadosInsuficientesException {
		if (produto.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ produto.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(produto);
	}

	public List<Produto> list() {
		return repository.list();
	}

}
