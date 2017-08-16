package br.edu.ifb.lpoow.model.business.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifb.lpoow.dto.mapper.IGenericMapper;
import br.edu.ifb.lpoow.exception.EntidadeJaExisteExcecao;
import br.edu.ifb.lpoow.exception.EntidadeNaoEncontradaExcecao;
import br.edu.ifb.lpoow.model.business.IBusiness;

public class AbstractFacade<E, D, PK extends Serializable> implements IBusinessFacade<D, PK> {
	private static final long serialVersionUID = 1L;

	@Inject
	private IBusiness<E, PK> business;

	protected IGenericMapper<E, D> mapper;

	@Override
	public void adicionar(D dto) throws EntidadeJaExisteExcecao {
		business.adicionar(mapper.converterParaEntidade(dto));
	}

	@Override
	public List<D> listar() {
		return mapper.converterParaDto(business.listar());
	}

	@Override
	public void remover(D dto) throws EntidadeNaoEncontradaExcecao {
		business.remover(mapper.converterParaEntidade(dto));
	}

	@Override
	public D atualizar(D dto) throws EntidadeNaoEncontradaExcecao {
		return mapper.converterParaDto(business.atualizar(mapper.converterParaEntidade(dto)));
	}

	@Override
	public D recuperar(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		return mapper.converterParaDto(business.recuperar(chavePrimaria));
	}

}
