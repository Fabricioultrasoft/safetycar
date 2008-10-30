package br.com.dimag.safetycar.business;

import br.com.dimag.safetycar.business.cadastro.Cadastro;
import br.com.dimag.safetycar.data.RepositoryCliente;
import br.com.dimag.safetycar.model.Cliente;

public class CadastroCliente extends Cadastro<Cliente> {

	protected CadastroCliente() throws Exception {
		super (RepositoryCliente.getInstance());
	}
}
