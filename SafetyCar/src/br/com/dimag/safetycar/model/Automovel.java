package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "placa" }) })
public class Automovel extends BaseEntity {

	@NotNull
	@NotEmpty
	@Length(max = 7)
	private String placa;

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String modelo;

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String marca;

	@NotNull
	@NotEmpty
	@Length(max = 50)
	private String cor;

	@NotNull
	@NotEmpty
	@Length(max = 4, min = 4)
	private String ano;

	@NotNull
	@NotEmpty
	@Length(max = 17)
	private String chassi;

	@NotNull
	private TipoCombustivel tipoCombustivel;

	public enum TipoCombustivel {
		ALCOOL("Alcool"), 
		GASOLINA("Gasolina"), 
		DIESEL("Diesel"), 
		GNV("Gnv"), 
		FLEX("Flex"),
		TETRAFUEL("Tetrafull");

		private String descricao;

		private TipoCombustivel(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
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

	@Override
	public String getTextDefault() {
		return this.placa;
	}

}
