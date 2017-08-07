package br.edu.ifb.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifb.model.business.ILoginBusiness;

@Path("/login")
public class LoginApi {
	@Inject
	private ILoginBusiness loginBusiness;

	@GET
	@Path("/autenticar/{usuario}/{senha}")
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean autenticar(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
		return loginBusiness.autenticar(usuario, senha);
	}

	@GET
	@Path("/isAutenticado")
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean isAutenticado() {
		return loginBusiness.isAutenticado();
	}

	@GET
	@Path("/getUsuarioAutenticado")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getUsuarioAutenticado() {
		return loginBusiness.getUsuarioAutenticado();
	}

}