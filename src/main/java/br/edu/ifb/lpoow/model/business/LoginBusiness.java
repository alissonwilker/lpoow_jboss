package br.edu.ifb.lpoow.model.business;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.dao.ILoginDao;

@Named
@SessionScoped
public class LoginBusiness implements ILoginBusiness, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean isAutenticado = false;
	private String usuarioAutenticado = null;
	
	@Inject
	private ILoginDao loginDao;
	
	@Override
	public boolean isAutenticado() {
		return isAutenticado;
	}

	@Override
	public boolean autenticar(String usuario, String senha) {
		if (loginDao.validarLogin(usuario, senha)) {
			isAutenticado = true;
			this.usuarioAutenticado = usuario;
		} else {
			isAutenticado = false;
			this.usuarioAutenticado = null;
		}

		return isAutenticado;
	}

	@Override
	public String getUsuarioAutenticado() {
		return usuarioAutenticado;
	}
}
