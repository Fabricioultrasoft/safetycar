package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name="PESSOA_ID")
public class Cliente extends Pessoa {
	
	@NotNull
	@Length(max=30)
	private String nome;
	@Length(max=30)
	private String endereco;
	
	@Length(max=10)
	private String telefone;
	
	@Length(max=10)
	private String telefoneComercial;
	
	@Length(max=10)
	private String telefoneCelular;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.trim();
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco.trim();
	}

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
