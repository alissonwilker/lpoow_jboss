package br.edu.ifb.lpoow.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.entity.Livro;

@Named
@RequestScoped
public class LivroDao extends AbstractDao<Livro, Integer> {
	private static final long serialVersionUID = 1L;

}