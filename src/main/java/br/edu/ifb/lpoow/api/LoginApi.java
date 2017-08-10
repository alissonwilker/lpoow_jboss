package br.edu.ifb.lpoow.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.ifb.lpoow.model.business.ILoginBusiness;

@Path("/login")
@Produces({ MediaType.APPLICATION_JSON })
public class LoginApi {
	@Inject
	private ILoginBusiness loginBusiness;

	@GET
	@Path("/autenticar/{usuario}/{senha}")
	public boolean autenticar(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
		return loginBusiness.autenticar(usuario, senha);
	}

	@GET
	@Path("/isAutenticado")
	public boolean isAutenticado() {
		return loginBusiness.isAutenticado();
	}

	@GET
	@Path("/getUsuarioAutenticado")
	public String getUsuarioAutenticado() {
		return loginBusiness.getUsuarioAutenticado();
	}

}