package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends BaseEntity {

	/**
	 * Nome do cliente ou da empresa
	 */
	@NotNull
	@NotEmpty
	@Length(max = 200)
	private String nomeRazaoSocial;

	@Length(max = 200)
	private String apelidoFantasia;

	@NotNull
	@NotEmpty
	@Length(max = 14, min = 11)
	private String cpfCnpj;
	
	@NotNull
	@NotEmpty
	private String numeroEndereco;
	
	
	@Length(max = 200)
	private String complementoEndereco;
	
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
	
	@ManyToOne
	@JoinColumn(name = "enderecoId")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Endereco endereco;
	
	@NotNull
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private TipoPessoa tipoPessoa;

	public enum TipoPessoa {
		JURIDICA("Jurídica"), 
		FISICA("Física");
	
		private String tipoPessoa;
		
		private TipoPessoa (String tipoPessoa){
			this.tipoPessoa = tipoPessoa;
		}
		
		public String getDescricao() {
			return tipoPessoa;
		}
	}
	
	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getApelidoFantasia() {
		return apelidoFantasia;
	}

	public void setApelidoFantasia(String apelidoFantasia) {
		this.apelidoFantasia = apelidoFantasia;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String getTextDefault(){
		return this.nomeRazaoSocial;
	}
	
}
