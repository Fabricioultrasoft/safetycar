package br.com.dimag.safetycar.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private Funcionario atendente;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "mecanicoId")
	private Funcionario mecanico;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente cliente;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "automovelId")
	private Automovel automovel;
	
	@OneToMany(mappedBy="ordemServico", cascade= CascadeType.ALL)  
	private List<OrdemServicoProduto> listOrdemServicoProduto; 

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

	public List<OrdemServicoProduto> getListOrdemServicoProduto() {
		return listOrdemServicoProduto;
	}

	public void setListOrdemServicoProduto(
			List<OrdemServicoProduto> listOrdemServicoProduto) {
		this.listOrdemServicoProduto = listOrdemServicoProduto;
	}


}
