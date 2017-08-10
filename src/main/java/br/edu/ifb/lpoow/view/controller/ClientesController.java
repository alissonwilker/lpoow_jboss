package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.persistence.entity.Cliente;

@Named
@RequestScoped
public class ClientesController extends AbstractController<Cliente, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarCliente(int cpfCliente, String nomeCliente) {
		Cliente cliente = new Cliente(cpfCliente, nomeCliente);
		try {
			super.adicionar(cliente);
		} catch (EntidadeJaExisteException e) {
			return "cadastrarCliente" + responseParams + "&entidadeJaExiste=true";
		}
		return "app" + responseParams;
	}

	public String removerCliente(Integer id) {
		super.remover(id);
		return "app" + responseParams;
	}
}