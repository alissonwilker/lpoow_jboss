package br.edu.ifb.lpoow.model.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Biblioteca", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "NOME", length = 20, unique = true, nullable = false)
	private String nome;

	@ManyToMany
	private List<Livro> livros = new ArrayList<Livro>();

	@ManyToMany
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public Biblioteca() {
	}

	public Biblioteca(String nome) {
		setNome(nome);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public List<Cliente> getClientes() {
		return clientes;
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

}