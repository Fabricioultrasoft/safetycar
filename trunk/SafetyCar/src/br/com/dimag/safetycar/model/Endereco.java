package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class Endereco extends BaseEntity{
	
	@NotNull
	@NotEmpty
	@Length(max = 200)
	private String logradouro;
	
	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String bairro;
	
	@NotNull
	@NotEmpty
	@Length(max = 200)
	private String municipio;
	
	@NotNull
	@NotEmpty
	@Length(max = 8, min = 8)
	private String cep;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "UF_ID")
	private UF uf;

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

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public UF getUf() {
		return uf;
	}

	@Override
	public String getTextDefault() {
		return logradouro;
	}
	
}
