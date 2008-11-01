package br.com.dimag.safetycar.business;

import java.util.List;

import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.exception.FacadeException;
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
		try {
			cadastroCliente = new CadastroCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cadastrarCliente(Cliente cliente) throws FacadeException{
		
		try {
			
			cadastroCliente.inserir(cliente);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException("Erro ao tentar inserir um cliente. Dados Insuficientes.");
		} catch (DataException e) {
			throw new FacadeException("Erro ao nos dados");
		}
	}
	
	
	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.setNome("Nome Clietne");
		c.setEndereco("Endereco1");
		
		try {
			Facade.getInstance().cadastrarCliente(c);
		} catch (FacadeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		Facade.getInstance().listCliente();
		
		System.out.println("ACABOU!!!!!!!!!!!!!!!!!!!!!!");
	}

	public List<Cliente> listCliente() {
		return cadastroCliente.list();
	}
	
}