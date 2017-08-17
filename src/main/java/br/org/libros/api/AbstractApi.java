package br.org.libros.api;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;

import br.org.libros.exception.EntidadeNaoEncontradaExcecao;
import br.org.libros.model.business.facade.IBusinessFacade;

public abstract class AbstractApi<T, PK extends Serializable> {
	protected Logger logger;

	@Inject
	protected IBusinessFacade<T, PK> businessFacade;

	public Response listar() {
		List<T> dtos = businessFacade.listar();
		return Response.ok(dtos).build();
	}
	
	public Response remover(PK chavePrimaria) {
		try {
			businessFacade.remover(chavePrimaria);
			return Response.ok().build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	public Response atualizar(PK chavePrimaria, T dto) {
		try {
			dto = businessFacade.atualizar(chavePrimaria, dto);
			return Response.ok(dto).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	public Response recuperar(PK chavePrimaria) {
		try {
			T dto = businessFacade.recuperar(chavePrimaria);
			return Response.ok(dto).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
