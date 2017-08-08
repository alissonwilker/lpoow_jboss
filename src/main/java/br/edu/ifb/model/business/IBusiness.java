package br.edu.ifb.model.business;

import java.util.List;

public interface IBusiness<T> {

	public void adicionar(T item);
	public List<T> listar();
}
