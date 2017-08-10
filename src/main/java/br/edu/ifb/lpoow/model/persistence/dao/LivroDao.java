package br.edu.ifb.lpoow.model.persistence.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifb.lpoow.model.persistence.entity.Livro;

@Named
@RequestScoped
@Transactional
public class LivroDao extends AbstractDao<Livro, Integer> {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Livro> listar() {
		return entityManager.createQuery("from Livro", Livro.class).getResultList();
	}

	@Override
	public Livro recuperar(Integer chavePrimaria) {
		return entityManager.find(Livro.class, chavePrimaria);
	}

}
