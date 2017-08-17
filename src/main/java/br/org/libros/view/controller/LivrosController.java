package br.org.libros.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.dto.LivroDto;
import br.org.libros.view.utils.JsfUtils;
import br.org.libros.view.utils.JsfUtils.Pagina;

@Named
@RequestScoped
public class LivrosController extends AbstractController<LivroDto, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarLivro(String isbnLivro, String nomeLivro) {
		LivroDto livroDto = new LivroDto(isbnLivro, nomeLivro);
		if (super.adicionar(livroDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}