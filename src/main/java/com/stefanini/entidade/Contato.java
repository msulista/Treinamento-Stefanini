package com.stefanini.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APR_CONTATO")
public class Contato {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONT_SEQ")
    @SequenceGenerator(name = "CONT_SEQ", sequenceName = "CONT_SEQ", allocationSize = 1)
    @Column(name = "ID_CONTATO", unique = true, nullable = false, precision = 38)
	private int id;
	
	@Column(name = "NOME", nullable = true, length = 100)
	private String nome;
	
	@Column(name = "EMAIL", nullable = true, length = 100)
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
