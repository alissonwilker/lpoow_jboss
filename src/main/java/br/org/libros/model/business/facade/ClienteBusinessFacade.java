package br.org.libros.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.dto.ClienteDto;
import br.org.libros.dto.mapper.IClienteMapper;
import br.org.libros.model.persistence.entity.Cliente;

@Named
@RequestScoped
@Transactional
public class ClienteBusinessFacade extends AbstractFacade<Cliente, ClienteDto, Integer> {

	private static final long serialVersionUID = 1L;

	public ClienteBusinessFacade() {
		mapper = IClienteMapper.INSTANCE;
	}

}
