package br.edu.ifb.lpoow.model.business;

import java.io.Serializable;
import java.util.List;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteExcecao;
import br.edu.ifb.lpoow.exception.EntidadeNaoEncontradaExcecao;

public interface IBusiness<T, PK extends Serializable> {

	public T adicionar(T entidade) throws EntidadeJaExisteExcecao;

	public List<T> listar();

	public void remover(T entidade) throws EntidadeNaoEncontradaExcecao;

	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

	public T atualizar(T entidade) throws EntidadeNaoEncontradaExcecao;

	public T recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao;

	public T atualizar(PK chavePrimaria, T entidade) throws EntidadeNaoEncontradaExcecao;

}
