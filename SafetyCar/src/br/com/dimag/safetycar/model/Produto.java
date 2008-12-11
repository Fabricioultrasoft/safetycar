package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"EAN"})})
public class Produto extends BaseEntity {
	
	@NotNull
	@NotEmpty
	@Length(max=50)
	private String descricao;
	
	//Código de Identificação do Produto.
	@NotNull
	@NotEmpty
	@Length(max=13)
	private String EAN;
	
	@NotNull
	@NotEmpty
	@Length(max=50)
	private String modelo;
	
	@NotNull
	@NotEmpty
	@Length(max=50)
	private String marca;
	
	@NotNull
	private double valorUnitario;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String ean) {
		EAN = ean;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String getTextDefault() {
		return descricao;
	}

}
