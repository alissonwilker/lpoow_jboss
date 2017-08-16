package br.edu.ifb.lpoow.model.business.facade;

import java.io.Serializable;
import java.util.List;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteExcecao;
import br.edu.ifb.lpoow.exception.EntidadeNaoEncontradaExcecao;

public interface IBusinessFacade<T, PK extends Serializable> extends Serializable {
	public void adicionar(T dto) throws EntidadeJaExisteExcecao;

	public List<T> listar();

	public void remover(T dto) throws EntidadeNaoEncontradaExcecao;

	public T atualizar(T dto) throws EntidadeNaoEncontradaExcecao;

	public T recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;
}
