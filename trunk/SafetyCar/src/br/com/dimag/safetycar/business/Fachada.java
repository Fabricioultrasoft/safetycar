package br.com.dimag.safetycar.business;

import br.com.dimag.safetycar.model.Cliente;

public class Fachada {

	private static Fachada fachada;

	public static Fachada getInstance(){
		if (fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}

	
	public void cadastrarCliente(Cliente cliente){
		System.out.println("Passou pela fachada. "+ cliente.getNome());
		//Um monte de codigo de negocio e percistencia
	}
	
	
	public static void main(String[] args) {
		Cliente c = new Cliente();
		
		Fachada.getInstance().cadastrarCliente(c);
	}
	
}
