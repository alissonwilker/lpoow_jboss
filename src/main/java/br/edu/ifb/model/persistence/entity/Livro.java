package br.edu.ifb.model.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Livro", uniqueConstraints = { @UniqueConstraint(columnNames = { "ISBN" }) })
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ISBN", nullable = false, unique = true, length = 11)
	private int isbn;

	@Column(name = "NOME", length = 20, nullable = false)
	private String nome;
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}