package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

@Entity
public class Usuario extends BaseEntity {
	
	private String login;
	
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
	
}