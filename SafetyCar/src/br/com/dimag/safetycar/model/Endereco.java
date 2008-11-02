package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
public class Endereco extends BaseEntity{
	@NotNull
	@Length(max = 200)
	private String logradouro;
	
	@NotNull
	@Length(max = 50)
	private String bairro;
	
	@NotNull
	@Length(max = 200)
	private String municipio;
	
	@NotNull
	@Length(max = 9, min = 9)
	private String cep;
	
	
	@NotNull
	private TipoEndereco tipoEndereco;
	
	public enum TipoEndereco{
		COMERCIAL, 
		RESIDENCIAL
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
