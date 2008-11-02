package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;


@Entity
public class Servico extends BaseEntity{
	
	@NotNull
	private double valorServico;
	
	
	@NotNull
	@Length(max = 200)
	private String Descricao;


	public double getValorServico() {
		return valorServico;
	}


	public void setValorServico(double valorServico) {
		this.valorServico = valorServico;
	}


	public String getDescricao() {
		return Descricao;
	}


	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	

}