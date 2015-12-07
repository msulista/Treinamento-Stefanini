package com.stefanini.entidade;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.stefanini.converter.BaseEntity;


@Entity
@Table(name="APR_CIDADE")
public class Cidade implements BaseEntity, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIDA_SEQ")
	@SequenceGenerator(name = "CIDA_SEQ", sequenceName = "CIDA_SEQ", allocationSize = 1)
	@Column(name = "ID_CIDADE", unique = true, nullable = false, precision = 38)
	private int id;
	
	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;		

	
	public Long getId() {
		return new Long(id);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

}
