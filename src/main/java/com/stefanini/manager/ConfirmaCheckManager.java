package com.stefanini.manager;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.stefanini.constraints.ConfirmaCheck;

@ManagedBean
@ApplicationScoped
public class ConfirmaCheckManager {

	public ConfirmaCheck[] getConfirmaCheck(){
	
		return ConfirmaCheck.values();		
	}
}
