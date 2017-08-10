package br.edu.ifb.lpoow.model.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.ifb.lpoow.model.persistence.entity.Employee;

@Named
@ApplicationScoped
public class LoginDao extends AbstractDao<Employee, Integer> implements ILoginDao, Serializable {
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(LoginDao.class);

	@Override
	public boolean validarLogin(String usuario, String senha) {
		logger.info("Validando login.");

		TypedQuery<Employee> query = entityManager.createQuery("from Employee where name = :name and role = :role",
				Employee.class);
		query.setParameter("name", usuario);
		query.setParameter("role", senha);
		List<Employee> employees = query.getResultList();
		return employees != null && !employees.isEmpty();
	}

	@Override
	public List<Employee> listar() {
		return entityManager.createQuery("from Employee", Employee.class).getResultList();
	}

	@Override
	public Employee recuperar(Integer chavePrimaria) {
		return entityManager.find(Employee.class, chavePrimaria);
	}
}
