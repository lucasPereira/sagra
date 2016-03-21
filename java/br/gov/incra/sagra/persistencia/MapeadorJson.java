package br.gov.incra.sagra.persistencia;

public interface MapeadorJson {

	public <T> String mapearEntidadeParaJson(T entidade);

	public <T> String mapearDocumentoParaJson(Documento<T> documento);

	public <T> T mapearJsonParaEntidade(String json, Class<T> classe);

	public <T> Documento<T> mapearJsonParaDocumento(String json, Class<T> classe);

}
