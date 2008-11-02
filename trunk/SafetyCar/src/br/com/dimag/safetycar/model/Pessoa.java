package br.com.dimag.safetycar.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends BaseEntity {

	/**
	 * Nome do cliente ou da empresa
	 */
	@NotNull
	@Length(max = 200)
	private String nomeRazaoSocial;

	@Length(max = 200)
	private String nomeFantasia;

	@NotNull
	@Length(max = 14, min = 11)
	private String cpfCnpj;

	@NotNull
	private TipoPessoa tipoPessoa;

	public enum TipoPessoa {
		JURIDICA, FISICA
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

}
