package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.persistence.entity.Livro;
import br.edu.ifb.lpoow.view.MessageUtils;

@Named
@RequestScoped
public class LivrosController extends AbstractController<Livro, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarLivro(String isbn, String nomeLivro) {
		Livro livro = new Livro(isbn, nomeLivro);
		try {
			super.adicionar(livro);
		} catch (EntidadeJaExisteException e) {
			MessageUtils.addInfoFacesMessage("excecao.livroJaExiste");
			return null;
		}
		return "app" + responseParams;
	}

	public String removerLivro(Livro livro) {
		super.remover(livro);
		return "app" + responseParams;
	}
	
}