package br.org.libros.model.business.facade;

import java.io.Serializable;
import java.util.List;

import br.org.libros.exception.EntidadeJaExisteExcecao;
import br.org.libros.exception.EntidadeNaoEncontradaExcecao;

public interface IBusinessFacade<T, PK extends Serializable> extends Serializable {
	public T adicionar(T dto) throws EntidadeJaExisteExcecao;

	public List<T> listar();

	public void remover(T dto) throws EntidadeNaoEncontradaExcecao;

	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

	public T atualizar(T dto) throws EntidadeNaoEncontradaExcecao;

	public T recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

	public T atualizar(PK chavePrimaria, T dto) throws EntidadeNaoEncontradaExcecao;
}
