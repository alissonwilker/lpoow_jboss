package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.entity.Livro;

@Named
@RequestScoped
public class LivrosController extends AbstractController<Livro, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarLivro(String isbn, String nomeLivro) {
		Livro livro = new Livro(isbn, nomeLivro);
		if (super.adicionar(livro)) {
			return adicionarRedirecionamentoComMensagens("app");
		}
		return null;
	}

}