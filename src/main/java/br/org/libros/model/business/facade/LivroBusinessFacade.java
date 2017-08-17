package br.org.libros.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.org.libros.dto.LivroDto;
import br.org.libros.dto.mapper.ILivroMapper;
import br.org.libros.model.persistence.entity.Livro;

@Named
@RequestScoped
@Transactional
public class LivroBusinessFacade extends AbstractFacade<Livro, LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	public LivroBusinessFacade() {
		mapper = ILivroMapper.INSTANCE;
	}

}
