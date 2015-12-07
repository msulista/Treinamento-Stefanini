package com.stefanini.manager;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLActions;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import com.stefanini.entidade.Contato;
import com.stefanini.service.ContatoService;

@ManagedBean
@URLMappings(mappings = {
        @URLMapping(id = "contato", pattern = "/contato", viewId = "/pages/contato/contato-listar.xhtml"),
        @URLMapping(id = "contato-incluir", pattern = "/incluir", viewId = "/pages/contato/contato-incluir.xhtml", parentId = "contato"),
        @URLMapping(id = "contato-editar", pattern = "/#{contatoManager.contato.id}/editar", viewId = "/pages/contato/contato-editar.xhtml", parentId = "contato")
        })
public class ContatoManager {

	private Contato contato = new Contato();
	
	private ContatoService service = new ContatoService();

	public ContatoManager(){
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public String save(){
		service.save(contato); 
		return "pretty:contato";
	}
	
	public String update(){
		service.update(contato);
		return "pretty:contato";
	}
	
	public List<Contato> listar(){
		return service.listar();
	}
	
	public void remove(int id){
		service.remove(id);
	}
	
	@URLActions(actions = { @URLAction(mappingId = "contato-editar", onPostback = false) })
    public void load() throws IOException {
        contato = service.getContatoById(contato.getId());
    }
	
}
