package br.com.dimag.safetycar.business.cadastro;


public class DadosInsuficientesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DadosInsuficientesException(String menssage) {
		super(menssage);
	}
}
