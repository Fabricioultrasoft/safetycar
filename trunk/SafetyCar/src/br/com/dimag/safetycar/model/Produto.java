package br.com.dimag.safetycar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"EAN"})})
public class Produto extends BaseEntity {
	
	@NotNull
	@Length(max=50)
	private String descricao;
	
	@NotNull
	@Length(max=12)
	private String EAN;
	
	@NotNull
	@Length(max=50)
	private String modelo;
	
	@NotNull
	@Length(max=50)
	private String marca;
	
	@NotNull
	private double valorUnitario;
	
//	@OneToMany(mappedBy="produto", cascade= CascadeType.ALL)
//	private List<OrdemServicoProduto> listOrdemServicoProduto; 

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

//	public List<OrdemServicoProduto> getListOrdemServicoProduto() {
//		return listOrdemServicoProduto;
//	}
//
//	public void setListOrdemServicoProduto(
//			List<OrdemServicoProduto> listOrdemServicoProduto) {
//		this.listOrdemServicoProduto = listOrdemServicoProduto;
//	}

}
