package br.edu.ifb.lpoow.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.ifb.lpoow.dto.BibliotecaDto;
import br.edu.ifb.lpoow.exception.EntidadeJaExisteExcecao;
import br.edu.ifb.lpoow.exception.EntidadeNaoEncontradaExcecao;
import br.edu.ifb.lpoow.model.business.facade.IBusinessFacade;

@Path("/bibliotecas")
@Produces({ MediaType.APPLICATION_JSON })
public class BibliotecasApi {
	private final Logger logger = LoggerFactory.getLogger(BibliotecasApi.class);

	@Inject
	private IBusinessFacade<BibliotecaDto, Integer> businessFacade;

	@POST
	@Path("/{nomeBiblioteca}")
	public Response adicionar(@PathParam("nomeBiblioteca") String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		try {
			businessFacade.adicionar(bibliotecaDto);
			return Response.created(new URI("/bibliotecas/" + bibliotecaDto.getId())).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return Response.serverError().build();
		}
	}

	@GET
	public Response listar() {
		List<BibliotecaDto> bibliotecasDto = businessFacade.listar();
		return Response.ok(bibliotecasDto).build();
	}

	@DELETE
	@Path("/{idBiblioteca}")
	public Response remover(@PathParam("idBiblioteca") Integer idBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto();
		bibliotecaDto.setId(idBiblioteca);
		try {
			businessFacade.remover(bibliotecaDto);
			return Response.ok().build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("/{idBiblioteca}/atualizar/{nomeBiblioteca}")
	public Response atualizar(@PathParam("idBiblioteca") Integer idBiblioteca,
			@PathParam("nomeBiblioteca") String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		bibliotecaDto.setId(idBiblioteca);
		try {
			bibliotecaDto = businessFacade.atualizar(bibliotecaDto);
			return Response.ok(bibliotecaDto).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{idBiblioteca}")
	public Response recuperar(@PathParam("idBiblioteca") Integer idBiblioteca) {
		BibliotecaDto bibliotecaDto;
		try {
			bibliotecaDto = businessFacade.recuperar(idBiblioteca);
			return Response.ok(bibliotecaDto).build();
		} catch (EntidadeNaoEncontradaExcecao e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}