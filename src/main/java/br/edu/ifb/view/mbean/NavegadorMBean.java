package br.edu.ifb.view.mbean;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class NavegadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String irParaLoginResponse() {
		return "loginResponse?faces-redirect=true";
	}
}
