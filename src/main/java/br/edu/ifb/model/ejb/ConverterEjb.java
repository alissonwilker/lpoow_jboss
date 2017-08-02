package br.edu.ifb.model.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Logger;

import br.edu.ifb.model.jpa.Employee;

@Stateless
public class ConverterEjb {
	private final Logger logger = Logger.getLogger(ConverterEjb.class);

	@PersistenceContext(unitName="MinhaPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	public void acessarBanco() {
		logger.info("estou no bean!!");
		Employee employee = entityManager.find(Employee.class, 3);
		logger.info("employee nome: " + employee.getName());
	}
}