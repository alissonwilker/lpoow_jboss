package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.dto.BibliotecaDto;
import br.edu.ifb.lpoow.view.utils.JsfUtils;
import br.edu.ifb.lpoow.view.utils.JsfUtils.Pagina;

@Named
@RequestScoped
public class BibliotecasController extends AbstractController<BibliotecaDto, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarBiblioteca(String nomeBiblioteca) {
		BibliotecaDto bibliotecaDto = new BibliotecaDto(nomeBiblioteca);
		if (super.adicionar(bibliotecaDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}