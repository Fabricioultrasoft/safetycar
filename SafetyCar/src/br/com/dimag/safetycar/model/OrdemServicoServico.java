package br.com.dimag.safetycar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

//@Entity
//@org.hibernate.annotations.Entity(mutable = false)
public class OrdemServicoServico {
	
	@Embeddable
	public static class Id implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5459306281217773619L;

		@Column(name = "ID_OS")
		private Integer osId;

		@Column(name = "ID_SERVICO")
		private Integer servicoId;

		@Override
		public boolean equals(Object arg0) {

			if (arg0 instanceof Id) {
				Id that = (Id) arg0;
				return this.osId.equals(that.osId)
						&& this.servicoId.equals(that.servicoId);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return osId.hashCode() + servicoId.hashCode();
		}
	}

	@EmbeddedId
	private Id id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_OS", insertable = false, updatable = false)
	@ForeignKey(name = "FK_OSSERVICO_OS_ID")
	private OrdemServico ordemServico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_SERVICO", insertable = false, updatable = false)
	@ForeignKey(name = "FK_OSSERVICO_SERVICO_ID")
	private Servico servico;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}


}
