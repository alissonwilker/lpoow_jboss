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
@Table(name = "Cliente", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true, length = 11)
	private int id;

	@Column(name = "CPF", nullable = false, unique = true, length = 11)
	private int cpf;

	@Column(name = "NOME", length = 20, unique = false, nullable = false)
	private String nome;

	@ManyToMany
	private List<Livro> livros = new ArrayList<Livro>();

	public Cliente() {
	}

	public Cliente(int cpf, String nome) {
		setCpf(cpf);
		setNome(nome);
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}