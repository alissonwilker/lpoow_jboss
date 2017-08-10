package br.edu.ifb.lpoow.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.entity.Livro;

@Named
@RequestScoped
public class LivroBusiness extends AbstractBusiness<Livro, Integer> {

	private static final long serialVersionUID = 1L;
}
