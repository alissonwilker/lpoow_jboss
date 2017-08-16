package br.edu.ifb.lpoow.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifb.lpoow.model.persistence.entity.Cliente;
import br.edu.ifb.lpoow.model.persistence.entity.Livro;

public class BibliotecaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private List<Livro> livros = new ArrayList<Livro>();
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public BibliotecaDto() {
	}
	
	public BibliotecaDto(String nomeBiblioteca) {
		setNome(nomeBiblioteca);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
