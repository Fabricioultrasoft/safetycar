package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.Length;

@Entity
@PrimaryKeyJoinColumn(name="PESSOA_ID")
public class Cliente extends Pessoa {
	

	@Length(max=10)
	private String telefone;
	
	@Length(max=10)
	private String telefoneComercial;
	
	@Length(max=10)
	private String telefoneCelular;

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	
}
