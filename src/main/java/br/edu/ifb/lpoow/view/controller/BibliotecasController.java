package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.persistence.entity.Biblioteca;
import br.edu.ifb.lpoow.view.MessageUtils;

@Named
@RequestScoped
public class BibliotecasController extends AbstractController<Biblioteca, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarBiblioteca(String nomeBiblioteca) {
		Biblioteca biblioteca = new Biblioteca(nomeBiblioteca);
		try {
			super.adicionar(biblioteca);
		} catch (EntidadeJaExisteException e) {
			MessageUtils.addInfoFacesMessage("excecao.bibliotecaJaExiste");
			return null;
		}
		return "app" + responseParams;
	}

	public String removerBiblioteca(Biblioteca biblioteca) {
		super.remover(biblioteca);
		return "app" + responseParams;
	}

}