package br.org.libros.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
public class BibliotecaDao extends AbstractDao<Biblioteca, Integer> {
	private static final long serialVersionUID = 1L;

}
