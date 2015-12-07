package com.stefanini.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.entidade.Contato;
import com.stefanini.util.JPAUtil;

public class ContatoService {
		
	public void save(Contato contato){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void update(Contato contato){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Contato> listar() {
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT * FROM APR_CONTATO", Contato.class);
		List<Contato> contatos = q.getResultList();
		manager.close();
		return contatos;
	}
	
	public Contato getContatoById(int id){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT * FROM APR_CONTATO WHERE ID_CONTATO = :idContato", Contato.class);
		q.setParameter("idContato", id);
		Contato contato = (Contato)q.getSingleResult();
		manager.close();
		return contato;
	}
	
	public void remove(int id){
		Contato contato = getContatoById(id);
		EntityManager manager = JPAUtil.getEntityManager();		
		manager.getTransaction().begin();
		manager.remove(manager.getReference(Contato.class, contato.getId()));
		manager.getTransaction().commit();
		manager.close();		
	}

}
