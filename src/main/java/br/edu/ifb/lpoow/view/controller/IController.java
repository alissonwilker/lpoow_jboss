package br.edu.ifb.lpoow.view.controller;

import java.io.Serializable;
import java.util.List;

public interface IController<T, PK extends Serializable> {

	public boolean adicionar(T entidade);

	public List<T> getItens();

	public T getItem(PK chavePrimaria);

	public void remover(T entidade);
}
