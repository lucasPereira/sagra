package br.gov.incra.sagra.persistencia;

public class Documento<T> {

	private String identificador;
	private T entidade;

	public Documento(String identificador, T entidade) {
		this.identificador = identificador;
		this.entidade = entidade;
	}

	public String identificador() {
		return identificador;
	}

	public T entidade() {
		return entidade;
	}

}
