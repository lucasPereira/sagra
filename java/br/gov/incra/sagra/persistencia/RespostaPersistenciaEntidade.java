package br.gov.incra.sagra.persistencia;

public class RespostaPersistenciaEntidade<T> {

	private Documento<T> documento;
	private Integer codigoDeEstado;

	public RespostaPersistenciaEntidade(Integer codigoDeEstado, Documento<T> documento) {
		this.codigoDeEstado = codigoDeEstado;
		this.documento = documento;
	}

	public RespostaPersistenciaEntidade(Integer codigoDeEstado) {
		this.codigoDeEstado = codigoDeEstado;
		this.documento = null;
	}

	public RespostaPersistenciaEntidade() {
		this.codigoDeEstado = null;
		this.documento = null;
	}

	public Boolean semExcecao() {
		return codigoDeEstado != null;
	}

	public Documento<T> documento() {
		return documento;
	}

	public Integer codigoDeEstado() {
		return codigoDeEstado;
	}

}
