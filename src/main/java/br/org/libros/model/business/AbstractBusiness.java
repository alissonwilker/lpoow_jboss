package br.org.libros.model.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.libros.exception.EntidadeJaExisteExcecao;
import br.org.libros.exception.EntidadeNaoEncontradaExcecao;
import br.org.libros.model.persistence.dao.IDao;

public abstract class AbstractBusiness<T, PK extends Serializable> implements IBusiness<T, PK>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDao<T, PK> dao;

	@Override
	public T adicionar(T entidade) throws EntidadeJaExisteExcecao {
		return dao.adicionar(entidade);
	}

	@Override
	public void remover(T entidade) throws EntidadeNaoEncontradaExcecao {
		dao.remover(entidade);
	}

	@Override
	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		dao.remover(chavePrimaria);
	}

	@Override
	public T atualizar(T entidade) throws EntidadeNaoEncontradaExcecao {
		return dao.atualizar(entidade);
	}

	@Override
	public List<T> listar() {
		return dao.listar();
	}

	@Override
	public T recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		return dao.recuperar(chavePrimaria);
	}
	
	@Override
	public T atualizar(PK chavePrimaria, T entidade) throws EntidadeNaoEncontradaExcecao {
		return dao.atualizar(chavePrimaria, entidade);
	}

}
