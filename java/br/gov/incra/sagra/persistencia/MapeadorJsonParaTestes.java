package br.gov.incra.sagra.persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import br.gov.incra.sagra.infraestrutura.Ambiente;

public class MapeadorJsonParaTestes implements MapeadorJson {

	private Ambiente ambiente;
	private MapeadorJsonPadrao mapeadorPadrao;

	public MapeadorJsonParaTestes(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.mapeadorPadrao = new MapeadorJsonPadrao();
	}

	@Override
	public <T> String mapearEntidadeParaJson(T entidade) {
		GsonBuilder construtorGson = new GsonBuilder();
		Gson gson = construtorGson.create();
		JsonElement elementoJson = gson.toJsonTree(entidade);
		String identificador = ambiente.geradorDeIdentificador().gerar();
		elementoJson.getAsJsonObject().addProperty("_id", identificador);
		return gson.toJson(elementoJson);
	}

	@Override
	public <T> String mapearDocumentoParaJson(Documento<T> documento) {
		return mapeadorPadrao.mapearDocumentoParaJson(documento);
	}

	@Override
	public <T> T mapearJsonParaEntidade(String json) {
		return mapeadorPadrao.mapearJsonParaEntidade(json);
	}

	@Override
	public <T> Documento<T> mapearJsonParaDocumento(String json) {
		return mapeadorPadrao.mapearJsonParaDocumento(json);
	}

}
