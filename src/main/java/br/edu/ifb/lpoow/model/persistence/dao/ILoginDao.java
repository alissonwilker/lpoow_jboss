package br.edu.ifb.lpoow.model.persistence.dao;

public interface ILoginDao {
	public boolean validarLogin(String usuario, String senha);
}
