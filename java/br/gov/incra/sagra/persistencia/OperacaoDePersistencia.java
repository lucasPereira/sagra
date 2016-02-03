package br.gov.incra.sagra.persistencia;

public class OperacaoDePersistencia<T> {

	private T valor;

	public OperacaoDePersistencia(T valor) {
		this.valor = valor;
	}

	public OperacaoDePersistencia() {
		this.valor = null;
	}

	public Boolean sucesso() {
		return (valor != null);
	}

	public T obterValor() {
		return valor;
	}

}
