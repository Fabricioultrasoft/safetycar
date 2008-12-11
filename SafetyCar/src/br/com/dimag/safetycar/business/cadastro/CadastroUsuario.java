package br.com.dimag.safetycar.business.cadastro;

import java.util.List;

import br.com.dimag.safetycar.data.RepositoryUsuario;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Usuario;

public class CadastroUsuario {

	private RepositoryUsuario repository;

	public CadastroUsuario() throws Exception {
		repository = RepositoryUsuario.getInstance();
	}

	public void inserir(Usuario usuario) throws DadosInsuficientesException,
			DataException {
		repository.insert(usuario);

	}

	public void atualizar(Usuario usuario) throws DadosInsuficientesException {
		if (usuario.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ usuario.getClass().getSimpleName() + " não possui ID.");
		}
		repository.update(usuario);
	}

	public void delete(Usuario usuario) throws DadosInsuficientesException {
		if (usuario.getId() == null) {
			throw new DadosInsuficientesException("O Objeto "
					+ usuario.getClass().getSimpleName() + " não possui ID.");
		}
		repository.delete(usuario);
	}

	public List<Usuario> list() {
		return repository.list();
	}

	public Usuario autenticacaoUsuario(String login, String senha) {
		return repository.autenticacaoUsuario(login,senha);
	}

	public List<Usuario> searchListServicoByDescricao(String login) {
		return repository.searchListServicoByDescricao(login);
	}
}
