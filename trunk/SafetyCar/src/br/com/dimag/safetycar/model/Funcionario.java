package br.com.dimag.safetycar.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name="PESSOA_ID")
@Table(uniqueConstraints={@UniqueConstraint(columnNames="matricula")})
public class Funcionario extends Pessoa {
	
	/**
	 * Rela��o tabela TipoFuncionario que possui descricao e salarioBase
	 */
	@ManyToOne
	private TipoFuncionario tipoFuncionario;
	
	@NotNull
	@GeneratedValue
	private int matricula;
	
	@NotNull
	private Date dataAdmissao;

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}
