package com.stefanini.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.entidade.Cidade;
import com.stefanini.util.JPAUtil;

public class CidadeService {
	
	public void save(){}
	public void update(){}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> listar(){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT * FROM APR_CIDADE ORDER BY NOME ASC", Cidade.class);
		List<Cidade> cidades = q.getResultList();
		manager.close();
		return cidades;
	}

	public Cidade getCidadeById(int id){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT * FROM APR_CIDADE WHERE ID_CIDADE = :valor", Cidade.class);
		q.setParameter("valor", id);
		Cidade cidade = (Cidade)q.getSingleResult();
		manager.close();
		return cidade;
	}
}
