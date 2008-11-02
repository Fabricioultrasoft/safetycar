package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"placa"})})
public class Automovel extends BaseEntity {
	
	@NotNull
	@Length(max=7)
	private String placa;
	
	@NotNull
	@Length(max=50)
	private String modelo;
	
	@NotNull
	@Length(max=50)
	private String marca;
	
	@NotNull
	@Length(max=50)
	private String cor;
	
	@NotNull
	@Length(max=4, min=4)
	private String ano;
	
	@NotNull
	@Length(max=17)
	private String chassi;

	@NotNull
	private TipoCombustivel tipoCombustivel;

	public enum TipoCombustivel {
		ALCOOL, GASOLINA, DIESEL, GNV, FLEX, TETRAFUEL
	}
	
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

}
