package br.edu.ifb.model.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.ifb.model.jpa.Employee;

@Stateless
public class ConverterEjb {
	private final Logger logger = LoggerFactory.getLogger(ConverterEjb.class);

	@PersistenceContext(unitName="MinhaPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	public void acessarBanco() {
		logger.info("estou no bean!!");
		Employee employee = entityManager.find(Employee.class, 3);
		logger.info("employee nome: " + employee.getName());
	}
}