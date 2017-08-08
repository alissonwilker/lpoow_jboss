package br.edu.ifb.view.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifb.model.business.ILoginBusiness;

@Named
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ILoginBusiness loginBusiness;

	private final String RESPONSE_PARAMS = "?faces-redirect=true";

	public String autenticar(String usuario, String senha) {
		boolean isAutenticado = loginBusiness.autenticar(usuario, senha);
		if (isAutenticado) {
			return "loginSuccess" + RESPONSE_PARAMS;
		} else {
			return "loginFailed" + RESPONSE_PARAMS;
		}
	}

	public String getUsuarioAutenticado() {
		return loginBusiness.getUsuarioAutenticado();
	}
	
}