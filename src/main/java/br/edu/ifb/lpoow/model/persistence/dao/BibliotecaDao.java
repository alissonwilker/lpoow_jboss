package br.edu.ifb.lpoow.model.persistence.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifb.lpoow.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
@Transactional
public class BibliotecaDao extends AbstractDao<Biblioteca, Integer> {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Biblioteca> listar() {
		return entityManager.createQuery("from Biblioteca", Biblioteca.class).getResultList();
	}

	@Override
	public Biblioteca recuperar(Integer chavePrimaria) {
		return entityManager.find(Biblioteca.class, chavePrimaria);
	}

}
