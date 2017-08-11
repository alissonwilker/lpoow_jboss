package br.edu.ifb.lpoow.model.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;

@Transactional
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
	public static <T> Class<T> getGenericTypeArgument(final Class<?> clazz, final int idx) {
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
	public void adicionar(T entidade) throws EntidadeJaExisteException {
		try {
			entityManager.persist(entidade);
		} catch (PersistenceException eeex) {
			if (eeex.getCause() instanceof ConstraintViolationException) {
				throw new EntidadeJaExisteException(eeex);
			} else {
				throw eeex;
			}
		}
	}

	@Override
	public void remover(T entidade) {
		entidade = entityManager.merge(entidade);
		entityManager.remove(entidade);
	}

	@Override
	public T atualizar(T entidade) {
		return entityManager.merge(entidade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T recuperar(PK chavePrimaria) {
		return (T) entityManager.find(getDomainClass(), chavePrimaria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		return entityManager.createQuery("from " + getDomainClass().getSimpleName()).getResultList();
	}

}
