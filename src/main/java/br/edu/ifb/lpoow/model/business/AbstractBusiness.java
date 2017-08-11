package br.edu.ifb.lpoow.model.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.persistence.dao.IDao;

public abstract class AbstractBusiness<T, PK extends Serializable> implements IBusiness<T, PK>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDao<T, PK> dao;

	@Override
	public void adicionar(T entidade) throws EntidadeJaExisteException {
		dao.adicionar(entidade);
	}

	@Override
	public void remover(T entidade) {
		dao.remover(entidade);
	}

	@Override
	public T atualizar(T entidade) {
		return dao.atualizar(entidade);
	}

	@Override
	public List<T> listar() {
		return dao.listar();
	}

	@Override
	public T recuperar(PK chavePrimaria) {
		return dao.recuperar(chavePrimaria);
	}
}
