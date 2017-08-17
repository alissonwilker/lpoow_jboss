package br.org.libros.model.business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.model.persistence.entity.Cliente;

@Named
@RequestScoped
public class ClienteBusiness extends AbstractBusiness<Cliente, Integer> {

	private static final long serialVersionUID = 1L;
}
