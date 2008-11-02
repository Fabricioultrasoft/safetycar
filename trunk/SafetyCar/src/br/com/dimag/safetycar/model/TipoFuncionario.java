package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
public class TipoFuncionario extends BaseEntity {
	
	@NotNull
	@Length(max=50)
	private String descricao;
	
	@NotNull
	private double salarioBase;
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
}
