package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.entity.Biblioteca;
import br.edu.ifb.lpoow.view.jsf.JsfUtils;
import br.edu.ifb.lpoow.view.jsf.JsfUtils.Pagina;

@Named
@RequestScoped
public class BibliotecasController extends AbstractController<Biblioteca, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarBiblioteca(String nomeBiblioteca) {
		Biblioteca biblioteca = new Biblioteca(nomeBiblioteca);
		if (super.adicionar(biblioteca)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}