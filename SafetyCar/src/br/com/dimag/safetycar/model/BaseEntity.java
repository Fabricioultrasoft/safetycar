package br.com.dimag.safetycar.model;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.NotNull;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@Basic
	@NotNull
	@GeneratedValue
	protected Integer id;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
