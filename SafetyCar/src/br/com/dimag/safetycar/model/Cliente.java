package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends BaseEntity {
	
	private String nome;
	private String endereco;
	private String telefone;
	
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
}
