package com.stefanini.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "APR_SUBMODULO")
public class Submodulo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBM_SEQ")
	@SequenceGenerator(name = "SUBM_SEQ", sequenceName = "SUBM_SEQ", allocationSize = 1)
	@Column(name = "ID_SUBMODULO", unique = true, nullable = false, precision = 38 )
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO")
	private Modulo modulo;
	
	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
