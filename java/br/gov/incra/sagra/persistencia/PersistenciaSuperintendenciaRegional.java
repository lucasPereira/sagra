package br.gov.incra.sagra.persistencia;

import java.util.LinkedList;
import java.util.List;

import br.gov.incra.sagra.entidades.SuperintendenciaRegional;
import br.gov.incra.sagra.infraestrutura.Ambiente;

public class PersistenciaSuperintendenciaRegional implements Persistencia<SuperintendenciaRegional> {

	private Ambiente ambiente;
	private List<Documento<SuperintendenciaRegional>> superintendencias;

	public PersistenciaSuperintendenciaRegional(Ambiente ambiente) {
		this.ambiente = ambiente;
		this.superintendencias = new LinkedList<>();
	}

	@Override
	public RespostaPersistenciaEntidade<SuperintendenciaRegional> cadastrar(SuperintendenciaRegional entidade) {
		String identificador = ambiente.auxiliarGeradorDeIdentificador().gerar();
		Documento<SuperintendenciaRegional> documento = new Documento<SuperintendenciaRegional>(identificador, entidade);
		RespostaPersistenciaEntidade<SuperintendenciaRegional> resposta = new RespostaPersistenciaEntidade<>(documento);
		superintendencias.add(resposta.documento());
		return resposta;
	}

	@Override
	public RespostaPersistenciaColecao<SuperintendenciaRegional> listar() {
		return null;
	}

}
