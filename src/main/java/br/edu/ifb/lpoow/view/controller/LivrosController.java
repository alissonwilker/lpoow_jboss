package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.entity.Livro;
import br.edu.ifb.lpoow.view.jsf.JsfUtils;
import br.edu.ifb.lpoow.view.jsf.JsfUtils.Pagina;

@Named
@RequestScoped
public class LivrosController extends AbstractController<Livro, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarLivro(String isbnLivro, String nomeLivro) {
		Livro livro = new Livro(isbnLivro, nomeLivro);
		if (super.adicionar(livro)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}