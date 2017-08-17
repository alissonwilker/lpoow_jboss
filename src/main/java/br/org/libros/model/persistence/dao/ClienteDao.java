package br.org.libros.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.model.persistence.entity.Cliente;

@Named
@RequestScoped
public class ClienteDao extends AbstractDao<Cliente, Integer> {
	private static final long serialVersionUID = 1L;

}
