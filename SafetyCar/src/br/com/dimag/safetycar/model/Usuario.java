package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
public class Usuario extends BaseEntity {
	
	@NotNull
	@NotEmpty
	@Length(max = 100)
	private String login;
	
	@NotNull
	@NotEmpty
	@Length(max = 100)
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getTextDefault() {
		return login;
	}
	
}
