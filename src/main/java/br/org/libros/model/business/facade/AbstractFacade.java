package br.org.libros.model.business.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.libros.dto.mapper.IGenericMapper;
import br.org.libros.exception.EntidadeJaExisteExcecao;
import br.org.libros.exception.EntidadeNaoEncontradaExcecao;
import br.org.libros.model.business.IBusiness;

public class AbstractFacade<E, D, PK extends Serializable> implements IBusinessFacade<D, PK> {
	private static final long serialVersionUID = 1L;

	@Inject
	private IBusiness<E, PK> business;

	protected IGenericMapper<E, D> mapper;

	@Override
	public D adicionar(D dto) throws EntidadeJaExisteExcecao {
		return mapper.converterParaDto(business.adicionar(mapper.converterParaEntidade(dto)));
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

	@Override
	public void remover(PK chavePrimaria) throws EntidadeNaoEncontradaExcecao {
		business.remover(chavePrimaria);
	}

	@Override
	public D atualizar(PK chavePrimaria, D dto) throws EntidadeNaoEncontradaExcecao {
		return mapper.converterParaDto(business.atualizar(chavePrimaria, mapper.converterParaEntidade(dto)));
	}

}
