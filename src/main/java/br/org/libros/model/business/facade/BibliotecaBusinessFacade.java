package br.org.libros.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.dto.BibliotecaDto;
import br.org.libros.dto.mapper.IBibliotecaMapper;
import br.org.libros.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
@Transactional
public class BibliotecaBusinessFacade extends AbstractFacade<Biblioteca, BibliotecaDto, Integer> {

	private static final long serialVersionUID = 1L;

	public BibliotecaBusinessFacade() {
		mapper = IBibliotecaMapper.INSTANCE;
	}

}
