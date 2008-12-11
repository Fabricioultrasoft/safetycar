package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class Endereco extends BaseEntity{
	
	@NotNull
	@NotEmpty
	private String numero;
	
	@NotNull
	@NotEmpty
	@Length(max = 200)
	private String complemento;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "ENDBASE_ID")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private EnderecoBase enderecoBase;
	
	@NotNull
	private TipoEndereco tipoEndereco;
	
	public enum TipoEndereco{
		COMERCIAL("Comercial"), 
		RESIDENCIAL("Residencial");
		
		private String descricao;
		
		private TipoEndereco (String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public EnderecoBase getEnderecoBase() {
		return enderecoBase;
	}

	public void setEnderecoBase(EnderecoBase enderecoBase) {
		this.enderecoBase = enderecoBase;
	}

}
