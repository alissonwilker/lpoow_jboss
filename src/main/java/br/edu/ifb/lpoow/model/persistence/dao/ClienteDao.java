package br.edu.ifb.lpoow.model.persistence.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.entity.Cliente;

@Named
@RequestScoped
public class ClienteDao extends AbstractDao<Cliente, Integer> {
	private static final long serialVersionUID = 1L;

}
