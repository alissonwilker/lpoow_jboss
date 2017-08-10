package br.edu.ifb.lpoow.view.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.business.IBusiness;

public abstract class AbstractController<T, PK extends Serializable> implements IController<T, PK>, Serializable {

	private static final long serialVersionUID = 1L;
	protected String responseParams = "?faces-redirect=true";

	@Inject
	private IBusiness<T, PK> business;

	@Override
	public void adicionar(T entidade) throws EntidadeJaExisteException {
		business.adicionar(entidade);
	}

	@Override
	public void remover(PK chavePrimaria) {
		business.remover(chavePrimaria);
	}
	
	@Override
	public List<T> getItens() {
		return business.listar();
	}

	@Override
	public T getItem(PK chavePrimaria) {
		return business.recuperar(chavePrimaria);
	}
	
}
