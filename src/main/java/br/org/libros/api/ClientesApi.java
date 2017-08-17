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

import br.org.libros.dto.ClienteDto;
import br.org.libros.exception.EntidadeJaExisteExcecao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/clientes")
@Api(value = "clientes")
@Produces({ MediaType.APPLICATION_JSON })
public class ClientesApi extends AbstractApi<ClienteDto, Integer> {

	@PostConstruct
	public void init() {
		logger = LoggerFactory.getLogger(ClientesApi.class);
	}

	@POST
	@Path("/{cpfCliente}/{nomeCliente}")
	@ApiOperation(value = "Adicionar um cliente")
	public Response adicionar(@PathParam("cpfCliente") String cpfCliente,
			@PathParam("nomeCliente") String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		try {
			clienteDto = businessFacade.adicionar(clienteDto);
			return Response.created(new URI("/clientes/" + clienteDto.getId())).build();
		} catch (EntidadeJaExisteExcecao e) {
			return Response.status(Status.CONFLICT).build();
		} catch (URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return Response.serverError().build();
		}
	}

	@Override
	@GET
	@ApiOperation(value = "Recuperar os clientes", response = ClienteDto.class, responseContainer = "List")
	public Response listar() {
		return super.listar();
	}

	@Override
	@DELETE
	@Path("/{idCliente}")
	@ApiOperation(value = "Remover um cliente")
	public Response remover(@PathParam("idCliente") Integer idCliente) {
		return super.remover(idCliente);
	}

	@PUT
	@Path("/{idCliente}/atualizar/{cpfCliente}/{nomeCliente}")
	@ApiOperation(value = "Atualizar um cliente", response = ClienteDto.class)
	public Response atualizar(@PathParam("idCliente") Integer idCliente, @PathParam("cpfCliente") String cpfCliente,
			@PathParam("nomeCliente") String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		clienteDto.setId(idCliente);
		return super.atualizar(idCliente, clienteDto);
	}

	@Override
	@GET
	@Path("/{idCliente}")
	@ApiOperation(value = "Recuperar um cliente", response = ClienteDto.class)
	public Response recuperar(@PathParam("idCliente") Integer idCliente) {
		return super.recuperar(idCliente);
	}

}