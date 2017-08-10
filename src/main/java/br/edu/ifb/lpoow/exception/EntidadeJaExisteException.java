package br.edu.ifb.lpoow.exception;

import javax.persistence.PersistenceException;

public class EntidadeJaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	private Throwable causaRaiz;

	public EntidadeJaExisteException(PersistenceException eeex) {
		this.causaRaiz = eeex;
	}

	public Throwable getCausaRaiz() {
		return causaRaiz;
	}
}
