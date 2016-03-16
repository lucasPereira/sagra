package br.gov.incra.sagra.persistencia;

public class Registro<T> {

	private String identificador;
	private T entidade;

	public Registro(String identificador, T entidade) {
		this.identificador = identificador;
		this.entidade = entidade;
	}

	public String obterIdentificador() {
		return identificador;
	}

	public T obterEntidade() {
		return entidade;
	}

}
