package com.stefanini.manager;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.stefanini.entidade.Cidade;
import com.stefanini.service.CidadeService;

@ManagedBean
public class CidadeManager {
	
	private Cidade cidade = new Cidade();
	private CidadeService service = new CidadeService();
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public CidadeService getService() {
		return service;
	}
	public void setService(CidadeService service) {
		this.service = service;
	}	
	public List<Cidade> listar(){
		return service.listar();
	}
	
}
