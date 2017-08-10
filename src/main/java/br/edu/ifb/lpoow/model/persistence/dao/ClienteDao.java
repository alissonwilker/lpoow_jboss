package br.edu.ifb.lpoow.model.persistence.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifb.lpoow.model.persistence.entity.Cliente;

@Named
@RequestScoped
@Transactional
public class ClienteDao extends AbstractDao<Cliente, Integer> {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Cliente> listar() {
		return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
	}

	@Override
	public Cliente recuperar(Integer chavePrimaria) {
		return entityManager.find(Cliente.class, chavePrimaria);
	}

}
