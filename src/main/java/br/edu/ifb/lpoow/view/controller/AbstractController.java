package br.edu.ifb.lpoow.view.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.business.IBusiness;
import br.edu.ifb.lpoow.view.jsf.JsfUtils;
import br.edu.ifb.lpoow.view.message.MessageUtils;

public abstract class AbstractController<T, PK extends Serializable> implements IController<T, PK>, Serializable {

	private static final long serialVersionUID = 1L;
	protected String responseParams = "?faces-redirect=true";

	@Inject
	private IBusiness<T, PK> business;

	@Override
	public boolean adicionar(T entidade) {
		try {
			business.adicionar(entidade);
			MessageUtils.addInfoFacesMessage("app.sucesso");
			return true;
		} catch (EntidadeJaExisteException e) {
			MessageUtils.addInfoFacesMessage("excecao.entidadeJaExiste", entidade.getClass().getSimpleName());
			return false;
		}
	}

	@Override
	public void remover(T entidade) {
		business.remover(entidade);
		MessageUtils.addInfoFacesMessage("app.sucesso"); 
	}

	@Override
	public List<T> getItens() {
		return business.listar();
	}

	@Override
	public T getItem(PK chavePrimaria) {
		return business.recuperar(chavePrimaria);
	}

	protected String adicionarRedirecionamentoComMensagens(String target) {
		JsfUtils.getFacesContext().getExternalContext().getFlash().setKeepMessages(true); 
		return target + responseParams; 
	}
}
