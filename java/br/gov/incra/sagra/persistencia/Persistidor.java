package br.gov.incra.sagra.persistencia;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

import br.gov.incra.sagra.infraestrutura.Ambiente;

public class Persistidor<T> {

	public RespostaPersistenciaEntidade<T> cadastrar(Ambiente ambiente, T entidade) {
		try {
			Gson gson = new Gson();
			JsonElement objetoJson = gson.toJsonTree(entidade);
			String identificadorGerado = ambiente.auxiliarGeradorDeIdentificador().gerar();
			objetoJson.getAsJsonObject().addProperty("_id", identificadorGerado);
			HttpRequestWithBody requisicao = Unirest.post("http://localhost:5984/sagra");
			requisicao.header("Content-Type", "application/json");
			requisicao.header("Accept", "application/json");
			requisicao.body(gson.toJson(objetoJson));
			HttpResponse<String> resposta = requisicao.asString();
			if (resposta.getStatus() == 201) {
				JsonElement respostaJson = gson.fromJson(resposta.getBody(), JsonElement.class);
				String identificador = respostaJson.getAsJsonObject().get("id").getAsString();
				Documento<T> documento = new Documento<T>(identificador, entidade);
				return new RespostaPersistenciaEntidade<>(documento);
			} else {
				return new RespostaPersistenciaEntidade<>();
			}
		} catch (UnirestException excecao) {
			return new RespostaPersistenciaEntidade<>();
		}
	}

}
