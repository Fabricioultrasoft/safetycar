package br.com.dimag.safetycar.business;

import br.com.dimag.safetycar.business.cadastro.DadosInsuficientesException;
import br.com.dimag.safetycar.model.Cliente;

public class Facade {

	private static Facade facade;
	private CadastroCliente cadastroCliente;

	public static Facade getInstance(){
		if (facade == null){
			facade = new Facade();
		}
		return facade;
	}

	public Facade(){
		cadastroCliente = new CadastroCliente();
	}
	
	public void cadastrarCliente(Cliente cliente) throws FacadeException{
		System.out.println("Passou pela fachada. "+ cliente.getNome());
		try {
			cadastroCliente.inserir(cliente);
		} catch (DadosInsuficientesException e) {
			// TODO Auto-generated catch block
			//Código para logar o erro detalhado num arquivo de log.
			throw new FacadeException("Erro ao tentar inserir um cliente. Dados Insuficientes.");
		}
	}
	
	
	public static void main(String[] args) {
		Cliente c = new Cliente();
		
		try {
			Facade.getInstance().cadastrarCliente(c);
		} catch (FacadeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
