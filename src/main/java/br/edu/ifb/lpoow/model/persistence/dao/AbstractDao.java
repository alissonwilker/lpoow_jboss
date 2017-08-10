package br.edu.ifb.lpoow.model.persistence.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;

public abstract class AbstractDao<T, PK extends Serializable> implements IDao<T, PK>, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "MinhaPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

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
		entityManager.remove(entidade);
	}

	@Override
	public void remover(PK chavePrimaria) {
		T entidade = recuperar(chavePrimaria);
		entityManager.remove(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		entityManager.merge(entidade);
	}

}
