package br.gov.incra.sagra.recursos;

public class Representacao<T> {

	private String uri;
	private T entidade;

	public Representacao(String uri, T entidade) {
		this.uri = uri;
		this.entidade = entidade;
	}

	public String uri() {
		return uri;
	}

	public T entidade() {
		return entidade;
	}

}
