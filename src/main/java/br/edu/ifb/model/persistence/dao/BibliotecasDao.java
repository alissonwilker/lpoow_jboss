package br.edu.ifb.model.persistence.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifb.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
@Transactional
public class BibliotecasDao extends AbstractDao implements IDao<Biblioteca>, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void adicionar(Biblioteca biblioteca) {
		entityManager.persist(biblioteca);
	}

	@Override
	public List<Biblioteca> listar() {
		return entityManager.createQuery("from Biblioteca", Biblioteca.class).getResultList();
	}

}
