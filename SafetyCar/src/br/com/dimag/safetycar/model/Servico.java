package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;


@Entity
public class Servico extends BaseEntity{
	
	@NotNull
	private double valorServico;
		
	@NotNull
	@NotEmpty
	@Length(max = 200)
	private String descricao;

	public double getValorServico() {
		return valorServico;
	}


	public void setValorServico(double valorServico) {
		this.valorServico = valorServico;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String getTextDefault() {
		return descricao;
	}

}
