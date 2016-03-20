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

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Documento) {
			Documento<?> outro = (Documento<?>) objeto;
			Boolean identificadorIgual = identificador.equals(outro.identificador);
			Boolean entidadeIgual = entidade.equals(outro.entidade);
			return identificadorIgual && entidadeIgual;
		}
		return super.equals(objeto);
	}

}
