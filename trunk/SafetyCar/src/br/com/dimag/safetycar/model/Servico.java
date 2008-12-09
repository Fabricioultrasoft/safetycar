package br.com.dimag.safetycar.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;


@Entity
public class Servico extends BaseEntity{
	
	@NotNull
	private double valorServico;
	
	
	@NotNull
	@Length(max = 200)
	private String Descricao;
	
//	@ManyToMany(fetch=FetchType.EAGER)  
//	@JoinTable(name="os_servico", schema="nolugar",  
//	joinColumns=@JoinColumn(name="idservico"),  
//	inverseJoinColumns=@JoinColumn(name="idos"))
//	private List<OrdemServico> ordemServicos;


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

//
//	public List<OrdemServico> getOrdemServicos() {
//		return ordemServicos;
//	}
//
//
//	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
//		this.ordemServicos = ordemServicos;
//	}
	

}
