package br.edu.ifb.lpoow.model.business.facade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.edu.ifb.lpoow.dto.LivroDto;
import br.edu.ifb.lpoow.dto.mapper.ILivroMapper;
import br.edu.ifb.lpoow.model.persistence.entity.Livro;

@Named
@RequestScoped
@Transactional
public class LivroBusinessFacade extends AbstractFacade<Livro, LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	public LivroBusinessFacade() {
		mapper = ILivroMapper.INSTANCE;
	}

}
