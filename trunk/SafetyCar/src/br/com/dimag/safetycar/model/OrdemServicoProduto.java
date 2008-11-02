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

@Entity
@org.hibernate.annotations.Entity(mutable = false)
public class OrdemServicoProduto {

	@Embeddable
	public static class Id implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -168591088788670839L;

		@Column(name = "ID_OS")
		private Integer osId;

		@Column(name = "ID_PRODUTO")
		private Integer produtoId;

		@Override
		public boolean equals(Object arg0) {

			if (arg0 instanceof Id) {
				Id that = (Id) arg0;
				return this.osId.equals(that.osId)
						&& this.produtoId.equals(that.produtoId);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return osId.hashCode() + produtoId.hashCode();
		}
	}

	@EmbeddedId
	private Id id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_OS", insertable = false, updatable = false)
	@ForeignKey(name = "FK_OSPRODUTO_OS_ID")
	private OrdemServico ordemServico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUTO", insertable = false, updatable = false)
	@ForeignKey(name = "FK_OSPRODUTO_PRODUTO_ID")
	private Produto produto;

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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
