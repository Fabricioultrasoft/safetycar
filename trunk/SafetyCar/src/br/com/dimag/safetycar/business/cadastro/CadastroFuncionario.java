package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryFuncionario;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Funcionario;

public class CadastroFuncionario {

	private RepositoryFuncionario repository;

	public CadastroFuncionario() throws Exception {
		repository = RepositoryFuncionario.getInstance();
	}

	public void inserir(Funcionario funcionario) throws DadosInsuficientesException,
			DataException {
		repository.insert(funcionario);

	}

	public void atualizar(Funcionario funcionario) throws DadosInsuficientesException {
		if (funcionario.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ funcionario.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(funcionario);
	}

	public void delete(Funcionario funcionario) throws DadosInsuficientesException {
		if (funcionario.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ funcionario.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(funcionario);
	}

	public List<Funcionario> list() {
		return repository.list();
	}

	public List<Funcionario> listAtendente() {
		
		return repository.listAtendente();
	}

	public List<Funcionario> listMecanico() {
		return repository.listMecanico();
	}

}
