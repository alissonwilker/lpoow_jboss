package br.edu.ifb.lpoow.exception;

public class EntidadeNaoEncontradaExcecao extends Excecao {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaExcecao(IllegalArgumentException iaex) {
		super(iaex);
	}

	public EntidadeNaoEncontradaExcecao() {
		super();
	}

}
