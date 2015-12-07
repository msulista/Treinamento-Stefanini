package com.stefanini.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.stefanini.constraints.ConfirmaCheck;

@Entity
@Table(name = "APR_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUA_SEQ")
	@SequenceGenerator(name = "USUA_SEQ", sequenceName = "USUA_SEQ", allocationSize = 1)
	@Column(name = "ID_USUARIO", unique = true, nullable = false, precision = 38)
	private int id;
	
	@Column(name = "CPF", unique = true, nullable = false)
	private BigDecimal cpf;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "TELEFONE")
	private BigDecimal telefone;
	
	@Column(name = "CELULAR")
	private BigDecimal celular;
	
	@Column(name = "CEP")
	private BigDecimal cep;
	
	@Column(name = "ENDERECO")
	private String endereco;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ATIVO")
	private ConfirmaCheck ativo;
	
	@Column(name = "DATA_ATUALIZACAO")
	private Date dataAtualizacao;
	
	@ManyToOne	
	@JoinColumn(name = "CIDADE_ID_CIDADE", referencedColumnName = "ID_CIDADE")
	private Cidade cidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCpf() {
		return cpf;
	}

	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
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

	public BigDecimal getTelefone() {
		return telefone;
	}

	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}

	public BigDecimal getCelular() {
		return celular;
	}

	public void setCelular(BigDecimal celular) {
		this.celular = celular;
	}

	public BigDecimal getCep() {
		return cep;
	}

	public void setCep(BigDecimal cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public ConfirmaCheck getAtivo() {
		return ativo;
	}

	public void setAtivo(ConfirmaCheck ativo) {
		this.ativo = ativo;		
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
