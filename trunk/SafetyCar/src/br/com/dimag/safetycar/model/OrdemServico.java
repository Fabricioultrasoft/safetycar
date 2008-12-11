package br.com.dimag.safetycar.model;

import java.util.GregorianCalendar;
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
	private GregorianCalendar data;

	@NotNull
	@Length(max = 200)
	private String defeitoReclamado;

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
	
	@ManyToMany()  
	@JoinTable(name="os_produto",   
	joinColumns=@JoinColumn(name="idos"),  
	inverseJoinColumns=@JoinColumn(name="idproduto"))
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private List<Produto> produtos;
	
	@NotNull
	private StatusOrdemServico statusOrdemServico;

	@NotNull
	private ClassificacaoOrdemServico classificacaoOrdemServico;
	
	public enum ClassificacaoOrdemServico {
		ABERTA, CANCELADA, FECHADA, QUITADA
	}

	public enum StatusOrdemServico {
		
		AGUARDANDO_INSPECAO ("AGUARDANDO_INSPEÇAO"),
		EM_INSPECAO("EM_INPECAO"),
		AGUARDANDO_AUTORIZACAO ("AGUARDANDO_AUTORIZAÇAO"), 
		AUTORIZADO ("AUTORIZADO"), 
		NAO_AUTORIZADA ("NAO AUTORIZADA"),
		EM_EXECUCAO("EM EXECUÇAO"),
		FINALIZADA ("FINALIZADA");
		
		private String descricao;
	
		private StatusOrdemServico(String descricao){
			this.descricao = descricao;
		}
		public String getDescricao(){
			return descricao;
		}
		
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	@Override
	public String getTextDefault() {
		return this.cliente.getNomeRazaoSocial() +" - " + this.getAutomovel().getPlaca() + " - "+this.defeitoReclamado;
	}

}
