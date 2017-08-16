package br.edu.ifb.lpoow.exception;

import javax.persistence.PersistenceException;

public class EntidadeJaExisteExcecao extends Excecao {

	private static final long serialVersionUID = 1L;

	public EntidadeJaExisteExcecao(PersistenceException eeex) {
		super(eeex);
	}

}
