package br.gov.incra.sagra.persistencia;

public class RespostaPersistenciaEntidade<T> {

	private Boolean sucesso;
	private Documento<T> documento;

	public RespostaPersistenciaEntidade(Documento<T> documento) {
		this.sucesso = true;
		this.documento = documento;
	}

	public RespostaPersistenciaEntidade() {
		this.sucesso = false;
		this.documento = null;
	}

	public Boolean sucesso() {
		return sucesso;
	}

	public Documento<T> documento() {
		return documento;
	}

}
