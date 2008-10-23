package br.com.dimag.safetycar.business;

import br.com.dimag.safetycar.model.Cliente;

public class Facade {

	private static Facade facade;

	public static Facade getInstance(){
		if (facade == null){
			facade = new Facade();
		}
		return facade;
	}

	
	public void cadastrarCliente(Cliente cliente){
		System.out.println("Passou pela fachada. "+ cliente.getNome());
		//Um monte de codigo de negocio e percistencia
	}
	
	
	public static void main(String[] args) {
		Cliente c = new Cliente();
		
		Facade.getInstance().cadastrarCliente(c);
	}
	
}
