package br.org.libros.api;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;
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

import org.slf4j.LoggerFactory;

import br.org.libros.dto.BibliotecaDto;
import br.org.libros.exception.EntidadeJaExisteExcecao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/bibliotecas")
@Api(value = "bibliotecas")
@Produces({ MediaType.APPLICATION_JSON })
public class BibliotecasApi extends AbstractApi<BibliotecaDto, Integer> {

	@PostConstruct
	public void init() {
		logger = LoggerFactory.getLogger(BibliotecasApi.class);
	}

	@POST
	@Path("/{nomeBiblioteca}")
	@ApiOperation(value = "Adicionar uma biblioteca")
	public Response adicionar(@PathParam("nomeBiblioteca") String nomeBiblioteca) {
		logger.error("este");
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		try {
			bibliotecaDto = businessFacade.adicionar(bibliotecaDto);
			return Response.created(new URI("/bibliotecas/" + bibliotecaDto.getId())).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return Response.serverError().build();
		}
	}

	@Override
	@GET
	@ApiOperation(value = "Recuperar as bibliotecas", response = BibliotecaDto.class, responseContainer = "List")
	public Response listar() {
		return super.listar();
	}

	@Override
	@DELETE
	@Path("/{idBiblioteca}")
	@ApiOperation(value = "Remover uma biblioteca")
	public Response remover(@PathParam("idBiblioteca") Integer idBiblioteca) {
		return super.remover(idBiblioteca);
	}

	@PUT
	@Path("/{idBiblioteca}/atualizar/{nomeBiblioteca}")
	@ApiOperation(value = "Atualizar uma biblioteca", response = BibliotecaDto.class)
	public Response atualizar(@PathParam("idBiblioteca") Integer idBiblioteca,
			@PathParam("nomeBiblioteca") String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		bibliotecaDto.setId(idBiblioteca);
		return super.atualizar(idBiblioteca, bibliotecaDto);
	}

	@Override
	@GET
	@Path("/{idBiblioteca}")
	@ApiOperation(value = "Recuperar uma biblioteca", response = BibliotecaDto.class)
	public Response recuperar(@PathParam("idBiblioteca") Integer idBiblioteca) {
		return super.recuperar(idBiblioteca);
	}

}