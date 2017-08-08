package br.edu.ifb.model.business;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifb.model.persistence.dao.IDao;
import br.edu.ifb.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
public class BibliotecasBusiness implements IBusiness<Biblioteca>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDao<Biblioteca> bibliotecasDao;

	@Override
	public void adicionar(Biblioteca biblioteca) {
		bibliotecasDao.adicionar(biblioteca);
	}

	@Override
	public List<Biblioteca> listar() {
		return bibliotecasDao.listar();
	}

}
