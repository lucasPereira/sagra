package br.gov.incra.sagra.persistencia;

import br.gov.incra.sagra.auxiliar.Limbo;

public class RespostaPersistencia<T> {

	private Boolean sucesso;
	private Documento<T> documento;

	public RespostaPersistencia(String identificador, T entidade) {
		this.sucesso = true;
		this.documento = new Documento<T>(identificador, entidade);
	}

	public RespostaPersistencia(Limbo limbo) {
		this.sucesso = true;
		this.documento = null;
	}

	public RespostaPersistencia() {
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
