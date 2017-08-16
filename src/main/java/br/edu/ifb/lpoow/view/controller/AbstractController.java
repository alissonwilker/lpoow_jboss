package br.edu.ifb.lpoow.view.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteExcecao;
import br.edu.ifb.lpoow.exception.EntidadeNaoEncontradaExcecao;
import br.edu.ifb.lpoow.model.business.facade.IBusinessFacade;
import br.edu.ifb.lpoow.view.utils.FacesMessageUtils;

public abstract class AbstractController<T, PK extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IBusinessFacade<T, PK> businessFacade;

	public boolean adicionar(T entidade) {
		try {
			businessFacade.adicionar(entidade);
			adicionarMensagemSucesso();
			return true;
		} catch (EntidadeJaExisteExcecao e) {
			FacesMessageUtils.addInfoFacesMessage("excecao.entidadeJaExiste", entidade.getClass().getSimpleName());
			return false;
		}
	}

	public void remover(T entidade) {
		try {
			businessFacade.remover(entidade);
			adicionarMensagemSucesso();
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemEntidadeNaoEncontrada();
		}
	}

	public List<T> getItens() {
		return businessFacade.listar();
	}

	public T getItem(PK chavePrimaria) {
		try {
			return businessFacade.recuperar(chavePrimaria);
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemEntidadeNaoEncontrada();
			return null;
		}
	}

	private void adicionarMensagemEntidadeNaoEncontrada() {
		FacesMessageUtils.addInfoFacesMessage("excecao.entidadeNaoEncontrada");
	}

	private void adicionarMensagemSucesso() {
		FacesMessageUtils.addInfoFacesMessage("app.sucesso");
	}

}
