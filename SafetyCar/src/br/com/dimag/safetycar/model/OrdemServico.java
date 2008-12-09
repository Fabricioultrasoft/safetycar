package br.com.dimag.safetycar.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
public class OrdemServico extends BaseEntity {

	@NotNull
	private Date data;

	@NotNull
	@Length(max = 200)
	private String defeitoReclamado;

	@NotNull
	private StatusOrdemServico statusOrdemServico;

	@NotNull
	private ClassificacaoOrdemServico classificacaoOrdemServico;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "atendenteId")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Funcionario atendente;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "mecanicoId")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Funcionario mecanico;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "clienteId")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Cliente cliente;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "automovelId")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Automovel automovel;
	
	@ManyToMany(fetch=FetchType.EAGER)  
	@JoinTable(name="os_servico",   
	joinColumns=@JoinColumn(name="idos"),  
	inverseJoinColumns=@JoinColumn(name="idservico"))
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private List<Servico> servicos;
	
	public enum ClassificacaoOrdemServico {
		ABERTA, CANCELADA, FECHADA, QUITADA
	}

	public enum StatusOrdemServico {
		AGUARDANDO_INSPECAO, EM_INSPECAO, AGUARDANDO_AUTORIZACAO, AUTORIZADO, NAO_AUTORIZADA, EM_EXECUCAO, FINALIZADA
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDefeitoReclamado() {
		return defeitoReclamado;
	}

	public void setDefeitoReclamado(String defeitoReclamado) {
		this.defeitoReclamado = defeitoReclamado;
	}

	public StatusOrdemServico getStatusOrdemServico() {
		return statusOrdemServico;
	}

	public void setStatusOrdemServico(StatusOrdemServico statusOrdemServico) {
		this.statusOrdemServico = statusOrdemServico;
	}

	public ClassificacaoOrdemServico getClassificacaoOrdemServico() {
		return classificacaoOrdemServico;
	}

	public void setClassificacaoOrdemServico(
			ClassificacaoOrdemServico classificacaoOrdemServico) {
		this.classificacaoOrdemServico = classificacaoOrdemServico;
	}

	public Funcionario getAtendente() {
		return atendente;
	}

	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}

	public Funcionario getMecanico() {
		return mecanico;
	}

	public void setMecanico(Funcionario mecanico) {
		this.mecanico = mecanico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}