package br.com.dimag.safetycar.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
public class Cliente extends BaseEntity {
	
	@NotNull
	@Length(max=30)
	private String nome;
	@Length(max=30)
	private String endereco;
	@Length(max=11)
	private String telefone;
	@OneToMany
	@JoinColumn(name="clienteId")
	private List<Automovel> listAutomovel;
	
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