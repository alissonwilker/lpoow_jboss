package br.edu.ifb.lpoow.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifb.lpoow.dto.BibliotecaDto;
import br.edu.ifb.lpoow.dto.mapper.IBibliotecaMapper;
import br.edu.ifb.lpoow.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
@Transactional
public class BibliotecaBusinessFacade extends AbstractFacade<Biblioteca, BibliotecaDto, Integer> {

	private static final long serialVersionUID = 1L;

	public BibliotecaBusinessFacade() {
		mapper = IBibliotecaMapper.INSTANCE;
	}

}
