package com.stefanini.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.entidade.Usuario;
import com.stefanini.util.JPAUtil;
import com.stefanini.util.Mensagem;

public class UsuarioService {	
	
	public boolean save(Usuario usuario){
		if(cpfExistisSave(usuario)){			
            Mensagem.add("Cpf informado já esta cadastrado");
			return true;
		}else{
			EntityManager manager = JPAUtil.getEntityManager();		
			manager.getTransaction().begin();
			usuario.setDataAtualizacao(new Date());
			manager.persist(usuario);
			manager.getTransaction().commit();
			manager.close();
			return false;
		}
	}
	
	public boolean update(Usuario usuario){		
		if(cpfExistisUpdate(usuario)){
			Mensagem.add("Cpf informado já esta cadastrado em outro usuário");
			return true;
		}else{
			EntityManager manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			usuario.setDataAtualizacao(new Date());
			manager.merge(usuario);
			manager.getTransaction().commit();
			manager.close();
			return false;
		}
		
	}	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar(){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT * FROM APR_USUARIO WHERE ATIVO = 'S'", Usuario.class);
		List<Usuario> usuarios = q.getResultList();
		manager.close();
		return usuarios;
	}	

	@SuppressWarnings("unchecked")
	public List<BigDecimal> listarTodosCpfsMenosOdoUsuarioPassado(Usuario usuario){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT U.CPF FROM APR_USUARIO U WHERE ID_USUARIO <> :id");
		q.setParameter("id", usuario.getId());		
		List<BigDecimal> list = q.getResultList();
		manager.close();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<BigDecimal> listarTodosCpf(){
		EntityManager manager = JPAUtil.getEntityManager();
		Query q = manager.createNativeQuery("SELECT U.CPF FROM APR_USUARIO U");
		List<BigDecimal> cpfUsuarios = q.getResultList();
		manager.close();
		return cpfUsuarios;
	}	
		
	public Usuario getUsuarioById(int id){
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		Query q = manager.createNativeQuery("SELECT * FROM APR_USUARIO WHERE ID_USUARIO = :id", Usuario.class);
		q.setParameter("id", id);
		Usuario usuario = (Usuario)q.getSingleResult();
		manager.close();
		return usuario;
	}
	
	public void remove(int id){
		Usuario usuario = getUsuarioById(id);
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.getReference(Usuario.class, usuario.getId()));
		manager.getTransaction().commit();
		manager.close();		
	}
	
	private boolean cpfExistisSave(Usuario usuario){	
		List<BigDecimal> cpfs = listarTodosCpf();
		for (BigDecimal cpf : cpfs) {
			if(cpf.compareTo(usuario.getCpf()) == 0){
				return true;
			}
		}		
		return false;
	}
	
	private boolean cpfExistisUpdate(Usuario usuario){	
		List<BigDecimal> cpfs = listarTodosCpfsMenosOdoUsuarioPassado(usuario);
		for (BigDecimal cpf : cpfs) {
			if(cpf.compareTo(usuario.getCpf()) == 0){
				return true;
			}
		}		
		return false;
	}
	
	
}
