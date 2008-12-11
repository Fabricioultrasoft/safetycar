package br.com.dimag.safetycar.model;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@Basic
	@GeneratedValue
	protected Integer id;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BaseEntity){
			BaseEntity baseEntity = (BaseEntity)obj;
			return baseEntity.getId() == this.getId();
		}
		return false;
	}
	
	public abstract String getTextDefault();
}

	