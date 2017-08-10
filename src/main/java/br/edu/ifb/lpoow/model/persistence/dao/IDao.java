package br.edu.ifb.lpoow.model.persistence.dao;

import java.io.Serializable;
import java.util.List;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;

public interface IDao<T, PK extends Serializable> {

	public void adicionar(T entidade) throws EntidadeJaExisteException;

	public List<T> listar();

	public void remover(T entidade);

	public void atualizar(T entidade);
	
	public T recuperar(PK chavePrimaria);

	void remover(PK chavePrimaria);
}
