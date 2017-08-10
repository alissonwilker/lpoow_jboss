package br.edu.ifb.lpoow.model.business;

public interface ILoginBusiness {
	public boolean autenticar(String usuario, String senha);

	public boolean isAutenticado();

	public String getUsuarioAutenticado();
}
