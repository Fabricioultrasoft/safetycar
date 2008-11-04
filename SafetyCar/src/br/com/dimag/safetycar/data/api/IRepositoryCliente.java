package br.com.dimag.safetycar.data.api;

import java.util.List;

import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;


public interface IRepositoryCliente extends IRepository<Cliente> {
	
	public List<Automovel> getListAutomovel();
}
