package br.org.libros.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
public class BibliotecaBusiness extends AbstractBusiness<Biblioteca, Integer> {

	private static final long serialVersionUID = 1L;

}
