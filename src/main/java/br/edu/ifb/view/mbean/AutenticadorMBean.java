package br.edu.ifb.view.mbean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AutenticadorMBean implements Serializable {
	@Inject
	private NavegadorMBean navegador;

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
	private boolean autenticado = false;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String autenticar() {
		if (usuario.equals("alisson") && senha.equals("senha")) {
			autenticado = true;
		} else {
			autenticado = false;
		}
		
		return navegador.irParaLoginResponse();
	}
	
	public boolean isAutenticado() {
		return autenticado;
	}
}
