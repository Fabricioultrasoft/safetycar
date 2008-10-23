package br.com.dimag.safetycar.business;

import br.com.dimag.safetycar.business.cadastro.Cadastro;
import br.com.dimag.safetycar.business.data.FactoryRepository;
import br.com.dimag.safetycar.model.Cliente;

public class Facade {

	private static Facade facade;
	private Cadastro<Cliente> cadastroCliente;

	public static Facade getInstance(){
		if (facade == null){
			facade = new Facade();
		}
		return facade;
	}

	public Facade(){
		cadastroCliente = new Cadastro<Cliente>(FactoryRepository.getIntance().getRepositoryCliente());
	}
	
	public void cadastrarCliente(Cliente cliente){
		System.out.println("Passou pela fachada. "+ cliente.getNome());
		cadastroCliente.inserir(cliente);
	}
	
	
	public static void main(String[] args) {
		Cliente c = new Cliente();
		
		Facade.getInstance().cadastrarCliente(c);
	}
	
}
