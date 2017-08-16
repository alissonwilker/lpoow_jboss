package br.edu.ifb.lpoow.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifb.lpoow.dto.ClienteDto;
import br.edu.ifb.lpoow.dto.mapper.IClienteMapper;
import br.edu.ifb.lpoow.model.persistence.entity.Cliente;

@Named
@RequestScoped
@Transactional
public class ClienteBusinessFacade extends AbstractFacade<Cliente, ClienteDto, Integer> {

	private static final long serialVersionUID = 1L;

	public ClienteBusinessFacade() {
		mapper = IClienteMapper.INSTANCE;
	}

}
