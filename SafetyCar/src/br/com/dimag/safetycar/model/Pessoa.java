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
	@Length(max = 14, min = 11)
	private String cpfCnpj;

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
	
	@ManyToOne
	@JoinColumn(name = "enderecoId")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Endereco endereco;
	

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
