package br.gov.incra.sagra.persistencia;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

import br.gov.incra.sagra.infraestrutura.Ambiente;

public class BancoDeDocumentos {

	public BancoDeDocumentos(Ambiente ambiente) {
		try {
			Unirest.delete(ambiente.persistenciaNome()).asBinary();
			Unirest.put(ambiente.persistenciaNome()).asBinary();
		} catch (UnirestException excecao) {
			excecao.printStackTrace();
		}
	}

	public <T> RespostaPersistenciaEntidade<T> cadastrar(Ambiente ambiente, T entidade) {
		try {
			String conteudo = ambiente.mapeadorJson().mapearEntidadeParaJson(entidade);
			HttpRequestWithBody requisicao = Unirest.post("http://localhost:5984/sagra");
			requisicao.header("Content-Type", "application/json");
			requisicao.header("Accept", "application/json");
			requisicao.body(conteudo);
			HttpResponse<String> resposta = requisicao.asString();
			Integer codigoDeEstado = resposta.getStatus();
			if (codigoDeEstado == 201) {
				JsonElement respostaJson = new Gson().fromJson(resposta.getBody(), JsonElement.class);
				String identificador = respostaJson.getAsJsonObject().get("id").getAsString();
				Documento<T> documento = new Documento<T>(identificador, entidade);
				return new RespostaPersistenciaEntidade<>(codigoDeEstado, documento);
			} else {
				return new RespostaPersistenciaEntidade<>(codigoDeEstado);
			}
		} catch (UnirestException excecao) {
			return new RespostaPersistenciaEntidade<>();
		}
	}

}
