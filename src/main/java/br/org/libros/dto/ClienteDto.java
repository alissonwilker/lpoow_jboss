package br.org.libros.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.org.libros.model.persistence.entity.Livro;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String cpf;

	private String nome;

	private List<Livro> livros = new ArrayList<Livro>();

	public ClienteDto() {
	}

	public ClienteDto(String cpfCliente, String nomeCliente) {
		setCpf(cpfCliente);
		setNome(nomeCliente);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

}
