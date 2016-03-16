package br.gov.incra.sagra.recursos;

public class Resposta<T> {

	private CodigoDeEstado codigo;
	private String localizacao;
	private T entidade;

	public Resposta(CodigoDeEstado codigo, String localizacao, T entidade) {
		this.codigo = codigo;
		this.localizacao = localizacao;
		this.entidade = entidade;
	}

	public Resposta(CodigoDeEstado codigo, T entidade) {
		this(codigo, null, entidade);
	}

	public Resposta(CodigoDeEstado codigo) {
		this(codigo, null, null);
	}

	public CodigoDeEstado codigoDeEstado() {
		return codigo;
	}

	public String localizacao() {
		return localizacao;
	}

	public T entidade() {
		return entidade;
	}

}
