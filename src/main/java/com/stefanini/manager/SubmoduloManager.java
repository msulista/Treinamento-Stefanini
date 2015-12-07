package com.stefanini.manager;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import com.stefanini.entidade.Submodulo;
import com.stefanini.service.SubmoduloService;

@ManagedBean
@URLMappings(mappings = {
		@URLMapping(id = "submodulo", pattern = "/submodulo", viewId = "/pages/submodulo/submodulo-listar.xhtml"),
		@URLMapping(id = "submodulo-incluir", pattern = "/incluir", viewId = "/pages/submodulo/submodulo-incluir.xhtml", parentId = "submodulo"),
		@URLMapping(id = "submodulo-editar", pattern = "/#{submoduloManager.submoduloSelecionado.id}/editar", viewId = "/pages/submodulo/submodulo-editar.xhtml", parentId = "submodulo")
})
public class SubmoduloManager {

	private Submodulo submoduloSelecionado = new Submodulo();
	private SubmoduloService service = new SubmoduloService();
	
	public Submodulo getSubmoduloSelecionado() {
		return submoduloSelecionado;
	}
	public void setSubmoduloSelecionado(Submodulo submoduloSelecionado) {
		this.submoduloSelecionado = submoduloSelecionado;
	}
	
	public SubmoduloService getService() {
		return service;
	}
	public void setService(SubmoduloService service) {
		this.service = service;
	}
	
	public String save(){
		this.service.save(submoduloSelecionado);
		return "pretty:submodulo";
	}
	
	public String update(){
		this.service.update(submoduloSelecionado);
		return "pretty:submodulo";
	}
	
	public List<Submodulo> listar(){
		return service.listar();
	}
	
	public void remove(int id){
		this.service.remove(id);
	}
	
	@URLActions(actions = {@URLAction(mappingId = "submodulo-editar", onPostback = false)})
	public void load() throws IOException{
		submoduloSelecionado = service.getSubmoduloById(submoduloSelecionado.getId());
	}
}
