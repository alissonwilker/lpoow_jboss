package br.org.libros.view.controller;
//package br.edu.ifb.lpoow.view.controller;
//
//import java.io.Serializable;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Named;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.core.MediaType;
//
//@Named
//@ApplicationScoped
//public class LoginControllerRestClient implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	private final String RESPONSE_PARAMS = "?faces-redirect=true";
//
//	public String autenticar(String usuario, String senha) {
//		Client client = ClientBuilder.newClient();
//		boolean isAutenticado = client.target("http://localhost:8080/lpoow_jboss/api/login/autenticar/" + usuario + "/" + senha)
//		        .request(MediaType.APPLICATION_JSON)
//		        .get(Boolean.class);
//		if (isAutenticado) {
//			return "loginSuccess" + RESPONSE_PARAMS;
//		} else {
//			return "loginFailed" + RESPONSE_PARAMS;
//		}
//	}
//
//	public String getUsuarioAutenticado() {
//		Client client = ClientBuilder.newClient();
//		String usuarioAutenticado = client.target("http://localhost:8080/lpoow_jboss/api/login/getUsuarioAutenticado")
//		        .request(MediaType.APPLICATION_JSON)
//		        .get(String.class);
//		return usuarioAutenticado;
//	}
//
//	public String getIsAutenticado() {
//		Client client = ClientBuilder.newClient();
//		String usuarioAutenticado = client.target("http://localhost:8080/lpoow_jboss/api/login/isAutenticado")
//		        .request(MediaType.APPLICATION_JSON)
//		        .get(String.class);
//		return usuarioAutenticado;
//	}
//}