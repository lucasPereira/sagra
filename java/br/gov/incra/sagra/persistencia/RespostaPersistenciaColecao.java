package br.gov.incra.sagra.persistencia;

import java.util.List;

public class RespostaPersistenciaColecao<T> {

	private Boolean sucesso;
	private List<Documento<T>> documentos;

	public RespostaPersistenciaColecao(List<Documento<T>> documentos) {
		this.sucesso = true;
		this.documentos = documentos;
	}

	public RespostaPersistenciaColecao() {
		this.sucesso = false;
		this.documentos = null;
	}

	public Boolean sucesso() {
		return sucesso;
	}

	public int tamanho() {
		return documentos.size();
	}

	public Documento<T> documento(Integer indice) {
		return documentos.get(indice);
	}

}
