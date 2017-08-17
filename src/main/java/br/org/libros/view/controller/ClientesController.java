package br.org.libros.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.org.libros.dto.ClienteDto;
import br.org.libros.view.utils.JsfUtils;
import br.org.libros.view.utils.JsfUtils.Pagina;

@Named
@RequestScoped
public class ClientesController extends AbstractController<ClienteDto, Integer> {

	private static final long serialVersionUID = 1L;
	
	public String adicionarCliente(String cpfCliente, String nomeCliente) {
		ClienteDto clienteDto = new ClienteDto(cpfCliente, nomeCliente);
		if (super.adicionar(clienteDto)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}