package br.com.dimag.safetycar.data.api;

import java.util.List;

import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.OrdemServico;


public interface IRepositoryOrdemServico extends IRepository<OrdemServico> {

	public List<Automovel> listAutomovel(Cliente cliente);

}
