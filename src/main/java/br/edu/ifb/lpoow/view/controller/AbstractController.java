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

	public boolean adicionar(T dto) {
		try {
			businessFacade.adicionar(dto);
			adicionarMensagemSucesso();
			return true;
		} catch (EntidadeJaExisteExcecao e) {
			FacesMessageUtils.addInfoFacesMessage("excecao.itemJaCadastrado");
			return false;
		}
	}

	public void remover(T dto) {
		try {
			businessFacade.remover(dto);
			adicionarMensagemSucesso();
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemItemNaoEncontrado();
		}
	}

	public List<T> getItens() {
		return businessFacade.listar();
	}

	public T getItem(PK chavePrimaria) {
		try {
			return businessFacade.recuperar(chavePrimaria);
		} catch (EntidadeNaoEncontradaExcecao e) {
			adicionarMensagemItemNaoEncontrado();
			return null;
		}
	}

	private void adicionarMensagemItemNaoEncontrado() {
		FacesMessageUtils.addInfoFacesMessage("excecao.itemNaoEncontrado");
	}

	private void adicionarMensagemSucesso() {
		FacesMessageUtils.addInfoFacesMessage("app.sucesso");
	}

}
