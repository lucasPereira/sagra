package br.gov.incra.sagra.recursos;

public class RespostaRecurso<T extends Representacao> {

	private T representacao;
	private CodigoDeEstado codigo;

	public RespostaRecurso(CodigoDeEstado codigo, T representacao) {
		this.codigo = codigo;
		this.representacao = representacao;
	}

	public RespostaRecurso(CodigoDeEstado codigo) {
		this.codigo = codigo;
		this.representacao = null;
	}

	public CodigoDeEstado codigoDeEstado() {
		return codigo;
	}

	public T representacao() {
		return representacao;
	}

}
