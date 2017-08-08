package br.edu.ifb.model.persistence.dao;

import java.util.List;

public interface IDao<T> {

	public void adicionar(T item);
	public List<T> listar();
}
