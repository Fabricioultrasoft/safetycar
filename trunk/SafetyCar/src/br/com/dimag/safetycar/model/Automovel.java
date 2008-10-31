package br.com.dimag.safetycar.model;

import javax.persistence.Entity;

@Entity
public class Automovel extends BaseEntity {
	
	private String placa;
	private String modelo;
	private String marca;
	private String cor;
	private String ano;
}
