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
	public RespostaPersistencia<SuperintendenciaRegional> cadastrar(SuperintendenciaRegional entidade) {
		String identificador = ambiente.auxiliarGeradorDeIdentificador().gerar();
		RespostaPersistencia<SuperintendenciaRegional> resposta = new RespostaPersistencia<>(identificador, entidade);
		superintendencias.add(resposta.documento());
		return resposta;
	}

}
