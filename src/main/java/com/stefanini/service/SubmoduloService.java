package com.stefanini.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.entidade.Submodulo;
import com.stefanini.util.JPAUtil;

public class SubmoduloService {

	public void save(Submodulo submodulo){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(submodulo);
		manager.getTransaction().commit();
		manager.close();		
	}
	
	public void update(Submodulo submodulo) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(submodulo);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Submodulo> listar(){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT *  FROM APR_SUBMODULO", Submodulo.class);
		List<Submodulo> submodulos = q.getResultList();
		manager.close();
		return submodulos;
	}

	public Submodulo getSubmoduloById(int id){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT * FROM APR_SUBMODULO WHERE ID_SUBMODULO = :idSub", Submodulo.class);
		q.setParameter("idSub", id);
		Submodulo submodulo = (Submodulo)q.getSingleResult();
		manager.close();
		return submodulo;
	}
	
	public void remove(int id){
		Submodulo submodulo = getSubmoduloById(id);
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.getReference(Submodulo.class, submodulo.getId()));
		manager.getTransaction().commit();
		manager.close();
	}
}
