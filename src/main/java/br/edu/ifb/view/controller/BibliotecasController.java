package br.edu.ifb.view.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.ifb.model.business.IBusiness;
import br.edu.ifb.model.persistence.entity.Biblioteca;

@Named
@RequestScoped
public class BibliotecasController implements Serializable {
	private final Logger logger = LoggerFactory.getLogger(BibliotecasController.class);

	private static final long serialVersionUID = 1L;

	@Inject
	private IBusiness<Biblioteca> bibliotecasBusiness;

	private final String RESPONSE_PARAMS = "?faces-redirect=true";

	public String adicionarBiblioteca(String nomeBiblioteca) {
		Biblioteca biblioteca = new Biblioteca(nomeBiblioteca);
		bibliotecasBusiness.adicionar(biblioteca);
		return "app" + RESPONSE_PARAMS;
	}

	public List<Biblioteca> getListaBibliotecas() {
		logger.info("Listando bibliotecas");
		return bibliotecasBusiness.listar();
	}

}