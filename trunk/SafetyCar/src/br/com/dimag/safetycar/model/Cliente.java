package br.com.dimag.safetycar.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends BaseEntity {
	
	@Column(nullable=false)
	private String nome;
	private String endereco;
	private String telefone;
	@OneToMany
	@JoinColumn(name="clienteId")
	private List<Automovel> listAutomovel;
	
	public Cliente(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.trim();
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco.trim();
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone.trim();
	}
	public List<Automovel> getListAutomovel() {
		return listAutomovel;
	}

	public void setListAutomovel(List<Automovel> listAutomovel) {
		this.listAutomovel = listAutomovel;
	}
}
