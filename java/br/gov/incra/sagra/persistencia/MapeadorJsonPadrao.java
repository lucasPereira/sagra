package br.gov.incra.sagra.persistencia;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import br.gov.incra.sagra.auxiliar.Entidade;

public class MapeadorJsonPadrao implements MapeadorJson {

	public <T> Type criarTipo() {
		return new TypeToken<T>() {}.getType();
	}

	@Override
	public <T> String mapearEntidadeParaJson(T objeto) {
		Gson gson = construirGson();
		return gson.toJson(objeto);
	}

	@Override
	public <T> String mapearDocumentoParaJson(Documento<T> documento) {
		Gson gson = construirGson();
		JsonElement json = gson.toJsonTree(documento.entidade());
		json.getAsJsonObject().addProperty("_id", documento.identificador());
		return gson.toJson(json);
	}

	@Override
	public <T> T mapearJsonParaEntidade(String json) {
		Gson gson = construirGson();
		T entidade = gson.fromJson(json, new TypeToken<Entidade>() {}.getType());
		return entidade;
	}

	@Override
	public <T> Documento<T> mapearJsonParaDocumento(String json) {
		Gson gson = construirGson();
		JsonElement elementoJson = gson.fromJson(json, JsonElement.class);
		String identificador = elementoJson.getAsJsonObject().get("_id").getAsString();
		T entidade = gson.fromJson(json, new TypeToken<Entidade>() {}.getType());
		return new Documento<T>(identificador, entidade);
	}

	private Gson construirGson() {
		GsonBuilder construtorGson = new GsonBuilder();
		Gson gson = construtorGson.create();
		return gson;
	}

}
