package br.edu.ifb.lpoow.view.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

import br.edu.ifb.lpoow.view.utils.FacesMessageUtils;
import br.edu.ifb.lpoow.view.utils.JsfUtils;
import br.edu.ifb.lpoow.view.utils.JsfUtils.Pagina;

@Named
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private boolean autenticado;

	public boolean isAutenticado() {
		return JsfUtils.getRequest().getUserPrincipal() != null;
	}

	public String getNomeUsuarioAutenticado() { 
		return JsfUtils.getRequest().getUserPrincipal().getName();
	}

	public boolean isUserInRole(String... roles) {
		boolean userIsInRole = false;
		int i = 0;
		while (i < roles.length && !userIsInRole) {
			userIsInRole = JsfUtils.getRequest().isUserInRole(roles[i++]);
		}
		return userIsInRole;
	}

	public void redirecionarSeAutenticado() throws IOException {
		if (isAutenticado()) {
			JsfUtils.redirecionar(Pagina.app);
		}
	}

	public String login(String usuario, String senha) {
		try {
			JsfUtils.getRequest().login(usuario, senha);
		} catch (ServletException e) {
			FacesMessageUtils.addInfoFacesMessage("login.falhou");
			return "";
		}

		return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
	}

	public String logout() {
		try {
			JsfUtils.getRequest().logout();
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.login);
		} catch (ServletException e) {
			FacesMessageUtils.addInfoFacesMessage("logout.falhou");
		}

		return "";
	}

}