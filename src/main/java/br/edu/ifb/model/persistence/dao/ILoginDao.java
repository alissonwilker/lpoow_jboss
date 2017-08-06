package br.edu.ifb.model.persistence.dao;

public interface ILoginDao {
	public boolean validarLogin(String usuario, String senha);
}
