package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.exception.EntidadeJaExisteException;
import br.edu.ifb.lpoow.model.persistence.entity.Cliente;
import br.edu.ifb.lpoow.view.message.MessageUtils;

@Named
@RequestScoped
public class ClientesController extends AbstractController<Cliente, Integer> {

	private static final long serialVersionUID = 1L;

	public String adicionarCliente(String cpfCliente, String nomeCliente) {
		Cliente cliente = new Cliente(cpfCliente, nomeCliente);
		try {
			super.adicionar(cliente);
		} catch (EntidadeJaExisteException e) {
			MessageUtils.addInfoFacesMessage("excecao.clienteJaExiste");
			return null;
		}
		return "app" + responseParams;
	}

	public String removerCliente(Cliente cliente) {
		super.remover(cliente);
		return "app";
	}
}