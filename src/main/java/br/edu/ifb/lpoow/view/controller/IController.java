package br.edu.ifb.lpoow.view.controller;

import java.io.Serializable;
import java.util.List;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;

public interface IController<T, PK extends Serializable> {

	public void adicionar(T entidade) throws EntidadeJaExisteException;

	public List<T> getItens();

	public T getItem(PK chavePrimaria);
	
	public void remover(T entidade);
}
