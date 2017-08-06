package br.edu.ifb.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.edu.ifb.model.business.ILoginBusiness;

@Path("/login")
public class LoginWs {
	@Inject
	private ILoginBusiness loginBusiness;

	@GET
	@Path("/autenticar")
	@Produces({ MediaType.TEXT_HTML })
	public String autenticar(@QueryParam("usuario") String usuario, @QueryParam("senha") String senha) {
		boolean isAutenticado = loginBusiness.autenticar(usuario, senha);
		return "<html lang=\"en\"><body><h1>" + isAutenticado + "</h1></body></html>";
	}
	
	@GET
	@Path("/isAutenticado")
	@Produces({ MediaType.TEXT_HTML })
	public String isAutenticado() {
		boolean isAutenticado = loginBusiness.isAutenticado();
		return "<html lang=\"en\"><body><h1>" + isAutenticado + "</h1></body></html>";
	}
}