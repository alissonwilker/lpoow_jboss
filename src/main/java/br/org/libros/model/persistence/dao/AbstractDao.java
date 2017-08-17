package br.org.libros.model.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import br.org.libros.exception.EntidadeJaExisteExcecao;
import br.org.libros.exception.EntidadeNaoEncontradaExcecao;

public abstract class AbstractDao<T, PK extends Serializable> implements IDao<T, PK>, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "MinhaPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	private Class<?> domain;

	private Class<?> getDomainClass() {
		if (this.domain == null) {
			this.domain = getGenericTypeArgument(this.getClass(), 0);
		}
		return this.domain;
	}

	@SuppressWarnings("unchecked")
	private static <T> Class<T> getGenericTypeArgument(final Class<?> clazz, final int idx) {
		final Type type = clazz.getGenericSuperclass();
		ParameterizedType paramType;
		try {
			paramType = (ParameterizedType) type;
		} catch (ClassCastException cause) {
			paramType = (ParameterizedType) ((Class<T>) type).getGenericSuperclass();
		}
		return (Class<T>) paramType.getActualTypeArguments()[idx];
	}

	@Override
	public T adicionar(T entidade) throws EntidadeJaExisteExcecao {
		try {
			entityManager.persist(entidade);
			return entidade;
		} catch (PersistenceException eeex) {
			if (eeex.getCause() instanceof ConstraintViolationException) {
				throw new EntidadeJaExisteExcecao(eeex);
			} else {
				throw eeex;
			}
		}
	}

	@Override
	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		T entidade = recuperar(chavePrimaria);
		if (entidade != null) {
			entityManager.remove(entidade);
		} else {
			throw new EntidadeNaoEncontradaExcecao();
		}
	}

	@Override
	public void remover(T entidade) throws EntidadeNaoEncontradaExcecao {
		try {
			entidade = entityManager.merge(entidade);
			entityManager.remove(entidade);
		} catch (IllegalArgumentException iaex) {
			throw new EntidadeNaoEncontradaExcecao(iaex);
		}
	}

	@Override
	public T atualizar(T entidade) throws EntidadeNaoEncontradaExcecao {
		try {
			return entityManager.merge(entidade);
		} catch (IllegalArgumentException iaex) {
			throw new EntidadeNaoEncontradaExcecao(iaex);
		}
	}

	@Override
	public T atualizar(PK chavePrimaria, T entidade) throws EntidadeNaoEncontradaExcecao {
		T entidadeRecuperada = recuperar(chavePrimaria);
		if (entidadeRecuperada != null) {
			try {
				return entityManager.merge(entidade);
			} catch (IllegalArgumentException iaex) {
				throw new EntidadeNaoEncontradaExcecao(iaex);
			}
		}
		throw new EntidadeNaoEncontradaExcecao();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		T entity = (T) entityManager.find(getDomainClass(), chavePrimaria);
		if (entity == null) {
			throw new EntidadeNaoEncontradaExcecao();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		return entityManager.createQuery("from " + getDomainClass().getSimpleName()).getResultList();
	}
	
}
