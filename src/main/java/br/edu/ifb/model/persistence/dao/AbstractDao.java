package br.edu.ifb.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class AbstractDao {
	@PersistenceContext(unitName="MinhaPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	
}
