package br.gov.incra.sagra.recursos;

public class RespostaRecurso<T> {

	private CodigoDeEstado codigo;
	private Representacao<T> representacao;

	public RespostaRecurso(CodigoDeEstado codigo, String uri, T entidade) {
		this.codigo = codigo;
		this.representacao = new Representacao<T>(uri, entidade);
	}

	public RespostaRecurso(CodigoDeEstado codigo) {
		this.codigo = codigo;
		this.representacao = null;
	}

	public CodigoDeEstado codigoDeEstado() {
		return codigo;
	}

	public Representacao<T> representacao() {
		return representacao;
	}

}
