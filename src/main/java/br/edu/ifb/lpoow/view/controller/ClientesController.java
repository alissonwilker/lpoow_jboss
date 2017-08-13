package br.edu.ifb.lpoow.view.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.ifb.lpoow.model.persistence.entity.Cliente;
import br.edu.ifb.lpoow.view.jsf.JsfUtils;
import br.edu.ifb.lpoow.view.jsf.JsfUtils.Pagina;

@Named
@RequestScoped
public class ClientesController extends AbstractController<Cliente, Integer> {

	private static final long serialVersionUID = 1L;
	
	public String adicionarCliente(String cpfCliente, String nomeCliente) {
		Cliente cliente = new Cliente(cpfCliente, nomeCliente);
		if (super.adicionar(cliente)) {
			return JsfUtils.getRedirecionamentoComMensagens(Pagina.app);
		}
		return "";
	}

}