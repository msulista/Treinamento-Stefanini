package com.stefanini.manager;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import com.stefanini.entidade.Usuario;
import com.stefanini.service.UsuarioService;

@ManagedBean
@URLMappings(mappings = {
		@URLMapping(id = "usuario", pattern = "/usuario", viewId = "/pages/usuario/usuario-listar.xhtml"),
		@URLMapping(id = "usuario-incluir", pattern = "/incluir", viewId = "/pages/usuario/usuario-incluir.xhtml", parentId = "usuario"),
		@URLMapping(id = "usuario-editar", pattern = "/#{usuarioManager.usuario.id}/editar", viewId = "/pages/usuario/usuario-editar.xhtml", parentId = "usuario")
})
public class UsuarioManager {

	private Usuario usuarioSelecionado = new Usuario();
	private UsuarioService service = new UsuarioService();
	
	public Usuario getUsuario() {
		return usuarioSelecionado;
	}
	public void setUsuario(Usuario usuario) {	
		this.usuarioSelecionado = usuario;
	}
	public UsuarioService getService() {
		return service;
	}
	public void setService(UsuarioService service) {
		this.service = service;
	}
	
	public String save(){		
		if(this.service.save(usuarioSelecionado)){
			//Mensagem.add("Cpf informado já esta cadastrado");
			return null;
		}else{
			return "pretty:usuario";
		}
	}	
	
	public String update(){
		if(this.service.update(usuarioSelecionado)){
			return null;
		}else{
			this.service.update(usuarioSelecionado);
			return "pretty:usuario";
		}
	}
	
	public List<Usuario> listar(){
		return service.listar();
	}
	
	public void remove(int id){
		this.service.remove(id);
	}
	
	@URLActions(actions ={
			@URLAction(mappingId = "usuario-editar", onPostback = false)
	})
	public void load() throws IOException{
		usuarioSelecionado = service.getUsuarioById(usuarioSelecionado.getId());
	}
	
}
