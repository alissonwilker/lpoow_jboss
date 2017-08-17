package br.org.libros.dto;

import java.io.Serializable;

public class LivroDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String isbn;

	private String nome;

	public LivroDto(){
	}
	
	public LivroDto(String isbnLivro, String nomeLivro) {
		setIsbn(isbnLivro);
		setNome(nomeLivro);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
