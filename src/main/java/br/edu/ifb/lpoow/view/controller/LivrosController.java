package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.persistence.entity.Livro;

@Named
@RequestScoped
public class LivrosController extends AbstractController<Livro, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarLivro(int isbn, String nomeLivro) {
		Livro livro = new Livro(isbn, nomeLivro);
		try {
			super.adicionar(livro);
		} catch (EntidadeJaExisteException e) {
			return "cadastrarLivro" + responseParams + "&entidadeJaExiste=true";
		}
		return "app" + responseParams;
	}

	public String removerLivro(Integer id) {
		super.remover(id);
		return "app" + responseParams;
	}
	
}